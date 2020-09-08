package cn.bdqn.entity;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * commodity
 * @author 
 */
@Data
@Entity
@Table(name = "commodity")
public class Commodity implements Serializable {
    @Id
    private Integer cid;

    private Integer number;

    private String tradeName;

    private Integer tradeMoeny;

    private Integer tradeNumber;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Commodity other = (Commodity) that;
        return (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getTradeName() == null ? other.getTradeName() == null : this.getTradeName().equals(other.getTradeName()))
            && (this.getTradeMoeny() == null ? other.getTradeMoeny() == null : this.getTradeMoeny().equals(other.getTradeMoeny()))
            && (this.getTradeNumber() == null ? other.getTradeNumber() == null : this.getTradeNumber().equals(other.getTradeNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getTradeName() == null) ? 0 : getTradeName().hashCode());
        result = prime * result + ((getTradeMoeny() == null) ? 0 : getTradeMoeny().hashCode());
        result = prime * result + ((getTradeNumber() == null) ? 0 : getTradeNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", number=").append(number);
        sb.append(", tradeName=").append(tradeName);
        sb.append(", tradeMoeny=").append(tradeMoeny);
        sb.append(", tradeNumber=").append(tradeNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}