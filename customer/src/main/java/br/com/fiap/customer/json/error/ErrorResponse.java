package br.com.fiap.customer.json.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse{
    private String messageError;

    public ErrorResponse(String statusText)
    {
        setMessageError(statusText);
    }
}
