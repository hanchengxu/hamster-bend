package com.example.hamster.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActiveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActiveExample() {
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

        public Criteria andActiveIdIsNull() {
            addCriterion("active_id is null");
            return (Criteria) this;
        }

        public Criteria andActiveIdIsNotNull() {
            addCriterion("active_id is not null");
            return (Criteria) this;
        }

        public Criteria andActiveIdEqualTo(Integer value) {
            addCriterion("active_id =", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotEqualTo(Integer value) {
            addCriterion("active_id <>", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdGreaterThan(Integer value) {
            addCriterion("active_id >", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_id >=", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLessThan(Integer value) {
            addCriterion("active_id <", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("active_id <=", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdIn(List<Integer> values) {
            addCriterion("active_id in", values, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotIn(List<Integer> values) {
            addCriterion("active_id not in", values, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdBetween(Integer value1, Integer value2) {
            addCriterion("active_id between", value1, value2, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("active_id not between", value1, value2, "activeId");
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

        public Criteria andHamsterIdEqualTo(Integer value) {
            addCriterion("hamster_id =", value, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdNotEqualTo(Integer value) {
            addCriterion("hamster_id <>", value, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdGreaterThan(Integer value) {
            addCriterion("hamster_id >", value, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hamster_id >=", value, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdLessThan(Integer value) {
            addCriterion("hamster_id <", value, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdLessThanOrEqualTo(Integer value) {
            addCriterion("hamster_id <=", value, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdIn(List<Integer> values) {
            addCriterion("hamster_id in", values, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdNotIn(List<Integer> values) {
            addCriterion("hamster_id not in", values, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdBetween(Integer value1, Integer value2) {
            addCriterion("hamster_id between", value1, value2, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andHamsterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hamster_id not between", value1, value2, "hamsterId");
            return (Criteria) this;
        }

        public Criteria andLapCountIsNull() {
            addCriterion("lap_count is null");
            return (Criteria) this;
        }

        public Criteria andLapCountIsNotNull() {
            addCriterion("lap_count is not null");
            return (Criteria) this;
        }

        public Criteria andLapCountEqualTo(Integer value) {
            addCriterion("lap_count =", value, "lapCount");
            return (Criteria) this;
        }

        public Criteria andLapCountNotEqualTo(Integer value) {
            addCriterion("lap_count <>", value, "lapCount");
            return (Criteria) this;
        }

        public Criteria andLapCountGreaterThan(Integer value) {
            addCriterion("lap_count >", value, "lapCount");
            return (Criteria) this;
        }

        public Criteria andLapCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("lap_count >=", value, "lapCount");
            return (Criteria) this;
        }

        public Criteria andLapCountLessThan(Integer value) {
            addCriterion("lap_count <", value, "lapCount");
            return (Criteria) this;
        }

        public Criteria andLapCountLessThanOrEqualTo(Integer value) {
            addCriterion("lap_count <=", value, "lapCount");
            return (Criteria) this;
        }

        public Criteria andLapCountIn(List<Integer> values) {
            addCriterion("lap_count in", values, "lapCount");
            return (Criteria) this;
        }

        public Criteria andLapCountNotIn(List<Integer> values) {
            addCriterion("lap_count not in", values, "lapCount");
            return (Criteria) this;
        }

        public Criteria andLapCountBetween(Integer value1, Integer value2) {
            addCriterion("lap_count between", value1, value2, "lapCount");
            return (Criteria) this;
        }

        public Criteria andLapCountNotBetween(Integer value1, Integer value2) {
            addCriterion("lap_count not between", value1, value2, "lapCount");
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