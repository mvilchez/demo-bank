package com.marino.demobank.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Balance
 */
@Validated
public class BalanceModel {
    @JsonProperty("balance")
    private BigDecimal balance = null;

    @JsonProperty("accountId")
    private String accountId = null;

    @JsonProperty("date")
    private String date = null;

    public BalanceModel balance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    /**
     * Get balance
     *
     * @return balance
     **/
    @ApiModelProperty(value = "")
    @Valid
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BalanceModel accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * Get accountId
     *
     * @return accountId
     **/
    @ApiModelProperty(value = "")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BalanceModel date(String date) {
        this.date = date;
        return this;
    }

    /**
     * Get date
     *
     * @return date
     **/
    @ApiModelProperty(value = "")
    @Valid
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BalanceModel balanceModel = (BalanceModel) o;
        return Objects.equals(this.balance, balanceModel.balance) &&
                Objects.equals(this.accountId, balanceModel.accountId) &&
                Objects.equals(this.date, balanceModel.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, accountId, date);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Balance {\n");

        sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
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

