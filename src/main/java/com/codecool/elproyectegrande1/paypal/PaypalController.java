package com.codecool.elproyectegrande1.paypal;

import com.codecool.elproyectegrande1.entity.Dreamer;
import com.codecool.elproyectegrande1.service.DreamerService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
@Slf4j
public class PaypalController {

    private final PaypalService paypalService;
    private final DreamerService dreamerService;

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/payment/create")
    public ResponseEntity<?> createPayment(
            @RequestParam("method") String method,
            @RequestParam("amount") String amount,
            @RequestParam("currency") String currency,
            @RequestParam("description") String description,
            @RequestParam("userId") String userId
    ) {
        UUID uuid = UUID.randomUUID();
        String param = uuid.toString();
        paypalService.saveParameter(param, userId);
        try {
            String cancelUrl = "http://localhost:8080/payment/cancel";
            String successUrl = "http://localhost:8080/payment/success?param=" + param + "&userId=" + userId;
            Dreamer dreamer = dreamerService.findDreamerByUserId(Long.valueOf(userId));
            dreamerService.donateDreamer(dreamer.getId(), BigDecimal.valueOf(Long.valueOf(amount)));
            Payment payment = paypalService.createPayment(
                    Double.valueOf(amount),
                    currency,
                    method,
                    "sale",
                    description,
                    cancelUrl,
                    successUrl
            );
            for (Links links: payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    return ResponseEntity.ok(links.getHref());
                }
            }
        } catch (PayPalRESTException e) {
            log.error("Error occurred::", e);
        }
        return ResponseEntity.ok("/paypal/error");
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/payment/success")
    public RedirectView paymentSuccess(
        @RequestParam("paymentId") String paymentId,
        @RequestParam("PayerID") String payerId,
        @RequestParam("param") String param,
        @RequestParam("userId") String userId
    ) {
        // find if the parameter string from database is equal to String param
        String parameter = paypalService.findParameter(userId);
        if (param.equals(parameter) && userId != null) {
            try {
                Payment payment = paypalService.executePayment(paymentId, payerId);
                if (payment.getState().equals("approved")) {
                    return new RedirectView("http://localhost:8081/paypal-success");
                }
            } catch (PayPalRESTException e) {
                log.error("Error occurred::", e);
            }
            return new RedirectView("http://localhost:8081/paypal-success");
        }
        else {
            log.error("Cannot access this resource, you are not authorized.");
            return new RedirectView("http://localhost:8081/");
        }
    }

    @GetMapping("/payment/cancel")
    public String paymentCancel() {
        return "paymentCancel";
    }

    @GetMapping("/payment/error")
    public String paymentError() {
        return "paymentError";
    }
}
