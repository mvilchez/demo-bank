package com.marino.demobank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DepositOrder
 */
@Validated
public class DepositOrder   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("destinationAccountId")
  private String destinationAccountId = null;

  @JsonProperty("date")
  private String date = null;

  public DepositOrder id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DepositOrder amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
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

  public DepositOrder description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DepositOrder destinationAccountId(String destinationAccountId) {
    this.destinationAccountId = destinationAccountId;
    return this;
  }

  /**
   * Get destinationAccountId
   * @return destinationAccountId
  **/
  @ApiModelProperty(value = "")
  public String getDestinationAccountId() {
    return destinationAccountId;
  }

  public void setDestinationAccountId(String destinationAccountId) {
    this.destinationAccountId = destinationAccountId;
  }

  public DepositOrder date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
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
    DepositOrder depositOrder = (DepositOrder) o;
    return Objects.equals(this.id, depositOrder.id) &&
        Objects.equals(this.amount, depositOrder.amount) &&
        Objects.equals(this.description, depositOrder.description) &&
        Objects.equals(this.destinationAccountId, depositOrder.destinationAccountId) &&
        Objects.equals(this.date, depositOrder.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, amount, description, destinationAccountId, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DepositOrder {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    destinationAccountId: ").append(toIndentedString(destinationAccountId)).append("\n");
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

