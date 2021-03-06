package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "DEMO_ACCOUNT_TYPE", schema = "VITRSA_SANDBOX")
public class AccountTransaction implements Serializable {

    private Long transactionId;
    private AccountType accountType;
    private String memberId;
    private String amount;
    private LocalDate transactionDate;

    public AccountTransaction() {
    }

    public AccountTransaction(Long transactionId, AccountType accountType, String memberId, String amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")

    @Column(name = "TX_ID")
    public Long getTransactionId() {
        return transactionId;
    }

    @Column(name = "MEMBER_ID")
    public String getMemberId() {
        return memberId;
    }

    @Column(name = "AMOUNT")
    public String getAmount() {
        return amount;
    }

    @Column(name = "TX_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccountTypeId(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accountType='" + accountType + '\'' +
                ", memberId='" + memberId + '\'' +
                ", amount='" + amount + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }

}
