package com.marino.demobank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * AccountEntry
 */
@Validated
public class AccountEntryModel {
    @JsonProperty("accountId")
    private String accountId = null;

    @JsonProperty("amount")
    private BigDecimal amount = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("date")
    private String date = null;

    public AccountEntryModel accountId(String accountId) {
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

    public AccountEntryModel amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    @ApiModelProperty(value = "")
    @Valid
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public AccountEntryModel description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @ApiModelProperty(value = "")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountEntryModel date(String date) {
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
        AccountEntryModel accountEntryModel = (AccountEntryModel) o;
        return Objects.equals(this.accountId, accountEntryModel.accountId) &&
                Objects.equals(this.amount, accountEntryModel.amount) &&
                Objects.equals(this.description, accountEntryModel.description) &&
                Objects.equals(this.date, accountEntryModel.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, amount, description, date);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountEntry {\n");

        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

