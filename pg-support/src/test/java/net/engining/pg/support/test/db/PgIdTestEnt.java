package net.engining.pg.support.test.db;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import net.engining.pg.support.meta.PropertyInfo;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**
 * PG_ID_TEST
 * @author pg-maven-plugin
 */
@Entity
@Table(name="pg_id_test")
@DynamicInsert(true)
@DynamicUpdate(true)
public class PgIdTestEnt implements Serializable {
    private static final long serialVersionUID = 1L;

    @PropertyInfo(name="SNOW_FLAKE_ID", length=64)
    @Id
    @GeneratedValue(generator="GEN_PG_ID_TEST")
    @GenericGenerator(name="GEN_PG_ID_TEST", strategy="net.engining.pg.support.db.id.generator.SnowflakeSequenceIdGenerator")
    @Column(name="SNOW_FLAKE_ID", nullable=false, length=64)
    private String snowFlakeId;

    @PropertyInfo(name="\u6279\u6267\u884C\u5E8F\u53F7", length=50)
    @Column(name="BATCH_NUMBER", nullable=true, length=50)
    private String batchNumber;

    public static final String _snowFlakeId = "snowFlakeId";

    public static final String _batchNumber = "batchNumber";

    /**
     * <p>SNOW_FLAKE_ID</p>
     * <p>###net.engining.pg.support.db.id.generator.SnowflakeSequenceIdGenerator###</p>
     */
    public String getSnowFlakeId() {
        return snowFlakeId;
    }

    /**
     * <p>SNOW_FLAKE_ID</p>
     * <p>###net.engining.pg.support.db.id.generator.SnowflakeSequenceIdGenerator###</p>
     */
    public void setSnowFlakeId(String snowFlakeId) {
        this.snowFlakeId = snowFlakeId;
    }

    /**
     * <p>批执行序号</p>
     */
    public String getBatchNumber() {
        return batchNumber;
    }

    /**
     * <p>批执行序号</p>
     */
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
        	.addValue(this.snowFlakeId)
        	.addValue(this.batchNumber)
        	.toString();
    }
}