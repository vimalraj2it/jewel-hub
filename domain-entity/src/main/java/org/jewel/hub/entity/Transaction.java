package org.jewel.hub.entity;

import jakarta.persistence.*;

/*@Entity
@Table(name = "transactionmstr")*/
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "txn_int_id", nullable = false, unique = true, updatable = false)
    private Long txnIntId;

    @Column(name = "txn_id", nullable = false, unique = true, length = 100) // Custom column mapping
    private String txnId;

    @Column(name = "txn_amount", nullable = false, unique = true, length = 100) // Custom column mapping
    private Double txnAmount;

    @Column(name = "currency", nullable = false, unique = true, length = 100) // Custom column mapping
    private String currency;

    @Column(name = "txn_ref", nullable = false, unique = true, length = 100) // Custom column mapping
    private String txnRef;

    @Column(name = "txn_status", nullable = false, unique = true, length = 100) // Custom column mapping
    private String txnStatus;


    public Long getTxnIntId() {
        return txnIntId;
    }

    public void setTxnIntId(Long txnIntId) {
        this.txnIntId = txnIntId;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public Double getTxnAmount() {
        return txnAmount;
    }

    public void setTxnAmount(Double txnAmount) {
        this.txnAmount = txnAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTxnRef() {
        return txnRef;
    }

    public void setTxnRef(String txnRef) {
        this.txnRef = txnRef;
    }

    public String getTxnStatus() {
        return txnStatus;
    }

    public void setTxnStatus(String txnStatus) {
        this.txnStatus = txnStatus;
    }
}
