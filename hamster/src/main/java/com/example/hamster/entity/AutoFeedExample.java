package com.example.hamster.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutoFeedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AutoFeedExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAutoFeedIdIsNull() {
            addCriterion("auto_feed_id is null");
            return (Criteria) this;
        }

        public Criteria andAutoFeedIdIsNotNull() {
            addCriterion("auto_feed_id is not null");
            return (Criteria) this;
        }

        public Criteria andAutoFeedIdEqualTo(Integer value) {
            addCriterion("auto_feed_id =", value, "autoFeedId");
            return (Criteria) this;
        }

        public Criteria andAutoFeedIdNotEqualTo(Integer value) {
            addCriterion("auto_feed_id <>", value, "autoFeedId");
            return (Criteria) this;
        }

        public Criteria andAutoFeedIdGreaterThan(Integer value) {
            addCriterion("auto_feed_id >", value, "autoFeedId");
            return (Criteria) this;
        }

        public Criteria andAutoFeedIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_feed_id >=", value, "autoFeedId");
            return (Criteria) this;
        }

        public Criteria andAutoFeedIdLessThan(Integer value) {
            addCriterion("auto_feed_id <", value, "autoFeedId");
            return (Criteria) this;
        }

        public Criteria andAutoFeedIdLessThanOrEqualTo(Integer value) {
            addCriterion("auto_feed_id <=", value, "autoFeedId");
            return (Criteria) this;
        }

        public Criteria andAutoFeedIdIn(List<Integer> values) {
            addCriterion("auto_feed_id in", values, "autoFeedId");
            return (Criteria) this;
        }

        public Criteria andAutoFeedIdNotIn(List<Integer> values) {
            addCriterion("auto_feed_id not in", values, "autoFeedId");
            return (Criteria) this;
        }

        public Criteria andAutoFeedIdBetween(Integer value1, Integer value2) {
            addCriterion("auto_feed_id between", value1, value2, "autoFeedId");
            return (Criteria) this;
        }

        public Criteria andAutoFeedIdNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_feed_id not between", value1, value2, "autoFeedId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdIsNull() {
            addCriterion("hamster_id is null");
            return (Criteria) this;
        }

        public Criteria andHamsterIdIsNotNull() {
            addCriterion("hamster_id is not null");
            return (Criteria) this;
        }

        public Criteria andHamsterIdEqualTo(Short value) {
            addCriterion("hamster_id =", value, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdNotEqualTo(Short value) {
            addCriterion("hamster_id <>", value, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdGreaterThan(Short value) {
            addCriterion("hamster_id >", value, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdGreaterThanOrEqualTo(Short value) {
            addCriterion("hamster_id >=", value, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdLessThan(Short value) {
            addCriterion("hamster_id <", value, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdLessThanOrEqualTo(Short value) {
            addCriterion("hamster_id <=", value, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdIn(List<Short> values) {
            addCriterion("hamster_id in", values, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdNotIn(List<Short> values) {
            addCriterion("hamster_id not in", values, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdBetween(Short value1, Short value2) {
            addCriterion("hamster_id between", value1, value2, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdNotBetween(Short value1, Short value2) {
            addCriterion("hamster_id not between", value1, value2, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andFeedTimeIsNull() {
            addCriterion("feed_time is null");
            return (Criteria) this;
        }

        public Criteria andFeedTimeIsNotNull() {
            addCriterion("feed_time is not null");
            return (Criteria) this;
        }

        public Criteria andFeedTimeEqualTo(Date value) {
            addCriterion("feed_time =", value, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeNotEqualTo(Date value) {
            addCriterion("feed_time <>", value, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeGreaterThan(Date value) {
            addCriterion("feed_time >", value, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("feed_time >=", value, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeLessThan(Date value) {
            addCriterion("feed_time <", value, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeLessThanOrEqualTo(Date value) {
            addCriterion("feed_time <=", value, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeIn(List<Date> values) {
            addCriterion("feed_time in", values, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeNotIn(List<Date> values) {
            addCriterion("feed_time not in", values, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeBetween(Date value1, Date value2) {
            addCriterion("feed_time between", value1, value2, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeNotBetween(Date value1, Date value2) {
            addCriterion("feed_time not between", value1, value2, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedAmountIsNull() {
            addCriterion("feed_amount is null");
            return (Criteria) this;
        }

        public Criteria andFeedAmountIsNotNull() {
            addCriterion("feed_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFeedAmountEqualTo(BigDecimal value) {
            addCriterion("feed_amount =", value, "feedAmount");
            return (Criteria) this;
        }

        public Criteria andFeedAmountNotEqualTo(BigDecimal value) {
            addCriterion("feed_amount <>", value, "feedAmount");
            return (Criteria) this;
        }

        public Criteria andFeedAmountGreaterThan(BigDecimal value) {
            addCriterion("feed_amount >", value, "feedAmount");
            return (Criteria) this;
        }

        public Criteria andFeedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("feed_amount >=", value, "feedAmount");
            return (Criteria) this;
        }

        public Criteria andFeedAmountLessThan(BigDecimal value) {
            addCriterion("feed_amount <", value, "feedAmount");
            return (Criteria) this;
        }

        public Criteria andFeedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("feed_amount <=", value, "feedAmount");
            return (Criteria) this;
        }

        public Criteria andFeedAmountIn(List<BigDecimal> values) {
            addCriterion("feed_amount in", values, "feedAmount");
            return (Criteria) this;
        }

        public Criteria andFeedAmountNotIn(List<BigDecimal> values) {
            addCriterion("feed_amount not in", values, "feedAmount");
            return (Criteria) this;
        }

        public Criteria andFeedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("feed_amount between", value1, value2, "feedAmount");
            return (Criteria) this;
        }

        public Criteria andFeedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("feed_amount not between", value1, value2, "feedAmount");
            return (Criteria) this;
        }

        public Criteria andInsertDateTimeIsNull() {
            addCriterion("insert_date_time is null");
            return (Criteria) this;
        }

        public Criteria andInsertDateTimeIsNotNull() {
            addCriterion("insert_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsertDateTimeEqualTo(Date value) {
            addCriterion("insert_date_time =", value, "insertDateTime");
            return (Criteria) this;
        }

        public Criteria andInsertDateTimeNotEqualTo(Date value) {
            addCriterion("insert_date_time <>", value, "insertDateTime");
            return (Criteria) this;
        }

        public Criteria andInsertDateTimeGreaterThan(Date value) {
            addCriterion("insert_date_time >", value, "insertDateTime");
            return (Criteria) this;
        }

        public Criteria andInsertDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insert_date_time >=", value, "insertDateTime");
            return (Criteria) this;
        }

        public Criteria andInsertDateTimeLessThan(Date value) {
            addCriterion("insert_date_time <", value, "insertDateTime");
            return (Criteria) this;
        }

        public Criteria andInsertDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("insert_date_time <=", value, "insertDateTime");
            return (Criteria) this;
        }

        public Criteria andInsertDateTimeIn(List<Date> values) {
            addCriterion("insert_date_time in", values, "insertDateTime");
            return (Criteria) this;
        }

        public Criteria andInsertDateTimeNotIn(List<Date> values) {
            addCriterion("insert_date_time not in", values, "insertDateTime");
            return (Criteria) this;
        }

        public Criteria andInsertDateTimeBetween(Date value1, Date value2) {
            addCriterion("insert_date_time between", value1, value2, "insertDateTime");
            return (Criteria) this;
        }

        public Criteria andInsertDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("insert_date_time not between", value1, value2, "insertDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeIsNull() {
            addCriterion("update_date_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeIsNotNull() {
            addCriterion("update_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeEqualTo(Date value) {
            addCriterion("update_date_time =", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeNotEqualTo(Date value) {
            addCriterion("update_date_time <>", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeGreaterThan(Date value) {
            addCriterion("update_date_time >", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date_time >=", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeLessThan(Date value) {
            addCriterion("update_date_time <", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_date_time <=", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeIn(List<Date> values) {
            addCriterion("update_date_time in", values, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeNotIn(List<Date> values) {
            addCriterion("update_date_time not in", values, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeBetween(Date value1, Date value2) {
            addCriterion("update_date_time between", value1, value2, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_date_time not between", value1, value2, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andInsertUserIsNull() {
            addCriterion("insert_user is null");
            return (Criteria) this;
        }

        public Criteria andInsertUserIsNotNull() {
            addCriterion("insert_user is not null");
            return (Criteria) this;
        }

        public Criteria andInsertUserEqualTo(String value) {
            addCriterion("insert_user =", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserNotEqualTo(String value) {
            addCriterion("insert_user <>", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserGreaterThan(String value) {
            addCriterion("insert_user >", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserGreaterThanOrEqualTo(String value) {
            addCriterion("insert_user >=", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserLessThan(String value) {
            addCriterion("insert_user <", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserLessThanOrEqualTo(String value) {
            addCriterion("insert_user <=", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserLike(String value) {
            addCriterion("insert_user like", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserNotLike(String value) {
            addCriterion("insert_user not like", value, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserIn(List<String> values) {
            addCriterion("insert_user in", values, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserNotIn(List<String> values) {
            addCriterion("insert_user not in", values, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserBetween(String value1, String value2) {
            addCriterion("insert_user between", value1, value2, "insertUser");
            return (Criteria) this;
        }

        public Criteria andInsertUserNotBetween(String value1, String value2) {
            addCriterion("insert_user not between", value1, value2, "insertUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}