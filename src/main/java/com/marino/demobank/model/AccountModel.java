package com.marino.demobank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Account
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-15T14:36:24.629Z")


public class AccountModel {
    @JsonProperty("id")
    private String id = null;

    @JsonProperty("accountNumberIban")
    private String accountNumberIban = null;

    @JsonProperty("accountNumberCCC")
    private String accountNumberCCC = null;

    @JsonProperty("holder")
    private User holder = null;

    public AccountModel id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Account id
     *
     * @return id
     **/
    @ApiModelProperty(value = "Account id")


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AccountModel accountNumberIban(String accountNumberIban) {
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

    public AccountModel accountNumberCCC(String accountNumberCCC) {
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

    public AccountModel holder(User holder) {
        this.holder = holder;
        return this;
    }

    /**
     * Get holder
     *
     * @return holder
     **/
    @ApiModelProperty(value = "")

    @Valid

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
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
        AccountModel accountModel = (AccountModel) o;
        return Objects.equals(this.id, accountModel.id) &&
                Objects.equals(this.accountNumberIban, accountModel.accountNumberIban) &&
                Objects.equals(this.accountNumberCCC, accountModel.accountNumberCCC) &&
                Objects.equals(this.holder, accountModel.holder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumberIban, accountNumberCCC, holder);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Account {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

