package org.acme.spring.web.model.response;

import java.util.Objects;

public class CepResponse {

    private String logradouro;

    private String bairro;

    private String localidade;

    public CepResponse(String logradouro, String bairro, String localidade) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
    }

    public CepResponse() {
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CepResponse that = (CepResponse) o;
        return Objects.equals(logradouro, that.logradouro) &&
                Objects.equals(bairro, that.bairro) &&
                Objects.equals(localidade, that.localidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, bairro, localidade);
    }
}
