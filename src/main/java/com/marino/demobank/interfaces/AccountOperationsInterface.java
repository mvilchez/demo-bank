package com.marino.demobank.interfaces;

import com.marino.demobank.domain.DepositOrder;
import com.marino.demobank.domain.Transfer;

public interface AccountOperationsInterface {
    public DepositOrder deposit (DepositOrder depositOrder);
    public Transfer transfer(Transfer transferOrder);
}
