package com.henrrycheng.chyftt.intermediary.experienceFraudRelation.bo;

import com.baidu.bjf.dao.ColumnDescription;
import com.baidu.bjf.dao.FieldAccessVo;
import com.baidu.bjf.dao.Id;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang.ObjectUtils;

/**
 * This bo is map to table : tb_relation_experience_fraud
 * Table description : 事情经过-欺骗手段-关系表
 * @author chengyong
 */
public abstract class RelationExperienceFraudBase extends FieldAccessVo implements Serializable {
    /** serial Version UID. */
    private static final long serialVersionUID = -1L;

    /** hashCode temporary storage. */
    private volatile Long hashCode;

    /** Use a WeakHashMap so entries will be garbage collected once all entities 
    referring to a saved hash are garbage collected themselves. */
    private static final Map<Serializable, Long> SAVED_HASHES = 
        Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_relation_experience_fraud.id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    @ColumnDescription(desc = "id")
    @Id
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_relation_experience_fraud.experience_id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    @ColumnDescription(desc = "事情经过id")
    private Long experienceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_relation_experience_fraud.fraud_means_id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    @ColumnDescription(desc = "欺骗手段id")
    private Long fraudMeansId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_relation_experience_fraud.score
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    @ColumnDescription(desc = "手段程度")
    private Long score;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_relation_experience_fraud.add_time
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    @ColumnDescription(desc = "添加时间")
    private Date addTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_relation_experience_fraud.add_user_id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    @ColumnDescription(desc = "添加人id")
    private Long addUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_relation_experience_fraud.update_time
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    @ColumnDescription(desc = "更新时间")
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_relation_experience_fraud.update_user_id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    @ColumnDescription(desc = "更新人id")
    private Long updateUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_relation_experience_fraud.is_deleted
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    @ColumnDescription(desc = "是否已逻辑删除，0未删除，1已删除")
    private Boolean isDeleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_relation_experience_fraud.id
     *
     * @return the value of tb_relation_experience_fraud.id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_relation_experience_fraud.id
     *
     * @param id the value for tb_relation_experience_fraud.id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public void setId(Long id) {
        // If we've just been persisted and hashCode has been
        // returned then make sure other entities with this
        // ID return the already returned hash code
        if ( this.id == null && id != null && this.hashCode != null ) {
            SAVED_HASHES.put( id, this.hashCode );
        }
        if (!ObjectUtils.equals(id, this.id)) {
            getChangeLogInfo().put("id", id);
        }
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_relation_experience_fraud.experience_id
     *
     * @return the value of tb_relation_experience_fraud.experience_id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public Long getExperienceId() {
        return experienceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_relation_experience_fraud.experience_id
     *
     * @param experienceId the value for tb_relation_experience_fraud.experience_id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public void setExperienceId(Long experienceId) {
        if (!ObjectUtils.equals(experienceId, this.experienceId)) {
            getChangeLogInfo().put("experienceId", experienceId);
        }
        this.experienceId = experienceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_relation_experience_fraud.fraud_means_id
     *
     * @return the value of tb_relation_experience_fraud.fraud_means_id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public Long getFraudMeansId() {
        return fraudMeansId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_relation_experience_fraud.fraud_means_id
     *
     * @param fraudMeansId the value for tb_relation_experience_fraud.fraud_means_id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public void setFraudMeansId(Long fraudMeansId) {
        if (!ObjectUtils.equals(fraudMeansId, this.fraudMeansId)) {
            getChangeLogInfo().put("fraudMeansId", fraudMeansId);
        }
        this.fraudMeansId = fraudMeansId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_relation_experience_fraud.score
     *
     * @return the value of tb_relation_experience_fraud.score
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public Long getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_relation_experience_fraud.score
     *
     * @param score the value for tb_relation_experience_fraud.score
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public void setScore(Long score) {
        if (!ObjectUtils.equals(score, this.score)) {
            getChangeLogInfo().put("score", score);
        }
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_relation_experience_fraud.add_time
     *
     * @return the value of tb_relation_experience_fraud.add_time
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_relation_experience_fraud.add_time
     *
     * @param addTime the value for tb_relation_experience_fraud.add_time
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public void setAddTime(Date addTime) {
        if (!ObjectUtils.equals(addTime, this.addTime)) {
            getChangeLogInfo().put("addTime", addTime);
        }
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_relation_experience_fraud.add_user_id
     *
     * @return the value of tb_relation_experience_fraud.add_user_id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public Long getAddUserId() {
        return addUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_relation_experience_fraud.add_user_id
     *
     * @param addUserId the value for tb_relation_experience_fraud.add_user_id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public void setAddUserId(Long addUserId) {
        if (!ObjectUtils.equals(addUserId, this.addUserId)) {
            getChangeLogInfo().put("addUserId", addUserId);
        }
        this.addUserId = addUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_relation_experience_fraud.update_time
     *
     * @return the value of tb_relation_experience_fraud.update_time
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_relation_experience_fraud.update_time
     *
     * @param updateTime the value for tb_relation_experience_fraud.update_time
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        if (!ObjectUtils.equals(updateTime, this.updateTime)) {
            getChangeLogInfo().put("updateTime", updateTime);
        }
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_relation_experience_fraud.update_user_id
     *
     * @return the value of tb_relation_experience_fraud.update_user_id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_relation_experience_fraud.update_user_id
     *
     * @param updateUserId the value for tb_relation_experience_fraud.update_user_id
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public void setUpdateUserId(Long updateUserId) {
        if (!ObjectUtils.equals(updateUserId, this.updateUserId)) {
            getChangeLogInfo().put("updateUserId", updateUserId);
        }
        this.updateUserId = updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_relation_experience_fraud.is_deleted
     *
     * @return the value of tb_relation_experience_fraud.is_deleted
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_relation_experience_fraud.is_deleted
     *
     * @param isDeleted the value for tb_relation_experience_fraud.is_deleted
     *
     * @mbggenerated Sat Mar 18 22:54:33 CST 2017
     */
    public void setIsDeleted(Boolean isDeleted) {
        if (!ObjectUtils.equals(isDeleted, this.isDeleted)) {
            getChangeLogInfo().put("isDeleted", isDeleted);
        }
        this.isDeleted = isDeleted;
    }

    @Override
    public int hashCode() {
        if ( this.hashCode == null ) {
            synchronized ( this ) {
                if ( this.hashCode == null ) {
                    Long newHashCode = null;
                    if ( getId() != null ) {
                        newHashCode = SAVED_HASHES.get( getId() );
                    }
                    
                    if ( newHashCode == null ) {
                        if ( getId() != null ) {
                            newHashCode = (long)getId().hashCode();
                        } else {
                            newHashCode = (long) super.hashCode();
                        }
                    }
                    this.hashCode = newHashCode;
                }
            }
        }
        return (int) (this.hashCode & 0xffffff);
    }

    @Override
    public boolean equals(final Object aThat) {
        
        if ( this == aThat ) {
            return true;
        }
        if( aThat == null ) {
            return false;
        }
        if (!( aThat instanceof RelationExperienceFraudBase )) {
            return false;
        }
        
        final RelationExperienceFraudBase THAT = (RelationExperienceFraudBase) aThat;
        boolean result = true;
        result = result && (((this.getId() == null) &&
             ( THAT.getId() == null)) || (this.getId() != null  && 
            this.getId().equals(THAT.getId())));
        return result;
    }
}