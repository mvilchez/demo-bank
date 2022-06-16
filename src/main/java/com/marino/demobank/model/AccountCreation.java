package com.marino.demobank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * AccountCreation
 */
@Validated
public class AccountCreation {
    @JsonProperty("accountNumberIban")
    private String accountNumberIban = null;

    @JsonProperty("accountNumberCCC")
    private String accountNumberCCC = null;

    @JsonProperty("holder")
    private String holder = null;

    public AccountCreation accountNumberIban(String accountNumberIban) {
        this.accountNumberIban = accountNumberIban;
        return this;
    }

    /**
     * International Banking Account Number
     *
     * @return accountNumberIban
     **/
    @ApiModelProperty(value = "International Banking Account Number")
    public String getAccountNumberIban() {
        return accountNumberIban;
    }

    public void setAccountNumberIban(String accountNumberIban) {
        this.accountNumberIban = accountNumberIban;
    }

    public AccountCreation accountNumberCCC(String accountNumberCCC) {
        this.accountNumberCCC = accountNumberCCC;
        return this;
    }

    /**
     * Spain Banking Account Number
     *
     * @return accountNumberCCC
     **/
    @ApiModelProperty(value = "Spain Banking Account Number")


    public String getAccountNumberCCC() {
        return accountNumberCCC;
    }

    public void setAccountNumberCCC(String accountNumberCCC) {
        this.accountNumberCCC = accountNumberCCC;
    }

    public AccountCreation holder(String holder) {
        this.holder = holder;
        return this;
    }

    /**
     * account holder
     *
     * @return holder
     **/
    @ApiModelProperty(value = "account holder")
    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountCreation accountCreation = (AccountCreation) o;
        return Objects.equals(this.accountNumberIban, accountCreation.accountNumberIban) &&
                Objects.equals(this.accountNumberCCC, accountCreation.accountNumberCCC) &&
                Objects.equals(this.holder, accountCreation.holder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumberIban, accountNumberCCC, holder);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountCreation {\n");

        sb.append("    accountNumberIban: ").append(toIndentedString(accountNumberIban)).append("\n");
        sb.append("    accountNumberCCC: ").append(toIndentedString(accountNumberCCC)).append("\n");
        sb.append("    holder: ").append(toIndentedString(holder)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

