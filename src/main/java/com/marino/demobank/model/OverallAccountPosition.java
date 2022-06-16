package com.marino.demobank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OverallAccountPosition
 */
@Validated
public class OverallAccountPosition {
    @JsonProperty("balance")
    private BalanceModel balanceModel = null;

    @JsonProperty("accountId")
    private String accountId = null;

    @JsonProperty("date")
    private String date = null;

    @JsonProperty("movements")
    @Valid
    private List<AccountEntryModel> movements = null;

    public OverallAccountPosition balance(BalanceModel balanceModel) {
        this.balanceModel = balanceModel;
        return this;
    }

    /**
     * Get balance
     *
     * @return balance
     **/
    @ApiModelProperty(value = "balance")
    @Valid
    public BalanceModel getBalance() {
        return balanceModel;
    }

    public void setBalance(BalanceModel balanceModel) {
        this.balanceModel = balanceModel;
    }

    public OverallAccountPosition accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * Get accountId
     *
     * @return accountId
     **/
    @ApiModelProperty(value = "accountId")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public OverallAccountPosition date(String date) {
        this.date = date;
        return this;
    }

    /**
     * Get date
     *
     * @return date
     **/
    @ApiModelProperty(value = "date")
    @Valid
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OverallAccountPosition movements(List<AccountEntryModel> movements) {
        this.movements = movements;
        return this;
    }

    public OverallAccountPosition addMovementsItem(AccountEntryModel movementsItem) {
        if (this.movements == null) {
            this.movements = new ArrayList<AccountEntryModel>();
        }
        this.movements.add(movementsItem);
        return this;
    }

    /**
     * array of account movements
     *
     * @return movements
     **/
    @ApiModelProperty(value = "array of account movements")

    @Valid

    public List<AccountEntryModel> getMovements() {
        return movements;
    }

    public void setMovements(List<AccountEntryModel> movements) {
        this.movements = movements;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OverallAccountPosition overallAccountPosition = (OverallAccountPosition) o;
        return Objects.equals(this.balanceModel, overallAccountPosition.balanceModel) &&
                Objects.equals(this.accountId, overallAccountPosition.accountId) &&
                Objects.equals(this.date, overallAccountPosition.date) &&
                Objects.equals(this.movements, overallAccountPosition.movements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceModel, accountId, date, movements);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OverallAccountPosition {\n");

        sb.append("    balance: ").append(toIndentedString(balanceModel)).append("\n");
        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    movements: ").append(toIndentedString(movements)).append("\n");
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

