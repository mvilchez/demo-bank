package com.marino.demobank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Transfer
 */
@Validated
public class Transfer {
    @JsonProperty("amount")
    private BigDecimal amount = null;

    @JsonProperty("destinationAccountId")
    private String destinationAccountId = null;

    @JsonProperty("originAccountId")
    private String originAccountId = null;

    @JsonProperty("date")
    private String date = null;

    public Transfer amount(BigDecimal amount) {
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

    public Transfer destinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
        return this;
    }

    /**
     * Get destinationAccountId
     *
     * @return destinationAccountId
     **/
    @ApiModelProperty(value = "")


    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    public Transfer originAccountId(String originAccountId) {
        this.originAccountId = originAccountId;
        return this;
    }

    /**
     * Get originAccountId
     *
     * @return originAccountId
     **/
    @ApiModelProperty(value = "")


    public String getOriginAccountId() {
        return originAccountId;
    }

    public void setOriginAccountId(String originAccountId) {
        this.originAccountId = originAccountId;
    }

    public Transfer date(String date) {
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
        Transfer transfer = (Transfer) o;
        return Objects.equals(this.amount, transfer.amount) &&
                Objects.equals(this.destinationAccountId, transfer.destinationAccountId) &&
                Objects.equals(this.originAccountId, transfer.originAccountId) &&
                Objects.equals(this.date, transfer.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, destinationAccountId, originAccountId, date);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Transfer {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    destinationAccountId: ").append(toIndentedString(destinationAccountId)).append("\n");
        sb.append("    originAccountId: ").append(toIndentedString(originAccountId)).append("\n");
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

