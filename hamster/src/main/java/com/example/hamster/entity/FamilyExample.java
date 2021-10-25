package com.example.hamster.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FamilyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FamilyExample() {
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

        public Criteria andFamilyIdIsNull() {
            addCriterion("family_id is null");
            return (Criteria) this;
        }

        public Criteria andFamilyIdIsNotNull() {
            addCriterion("family_id is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyIdEqualTo(Integer value) {
            addCriterion("family_id =", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotEqualTo(Integer value) {
            addCriterion("family_id <>", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdGreaterThan(Integer value) {
            addCriterion("family_id >", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("family_id >=", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdLessThan(Integer value) {
            addCriterion("family_id <", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdLessThanOrEqualTo(Integer value) {
            addCriterion("family_id <=", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdIn(List<Integer> values) {
            addCriterion("family_id in", values, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotIn(List<Integer> values) {
            addCriterion("family_id not in", values, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdBetween(Integer value1, Integer value2) {
            addCriterion("family_id between", value1, value2, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("family_id not between", value1, value2, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyNameIsNull() {
            addCriterion("family_name is null");
            return (Criteria) this;
        }

        public Criteria andFamilyNameIsNotNull() {
            addCriterion("family_name is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyNameEqualTo(String value) {
            addCriterion("family_name =", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameNotEqualTo(String value) {
            addCriterion("family_name <>", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameGreaterThan(String value) {
            addCriterion("family_name >", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameGreaterThanOrEqualTo(String value) {
            addCriterion("family_name >=", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameLessThan(String value) {
            addCriterion("family_name <", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameLessThanOrEqualTo(String value) {
            addCriterion("family_name <=", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameLike(String value) {
            addCriterion("family_name like", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameNotLike(String value) {
            addCriterion("family_name not like", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameIn(List<String> values) {
            addCriterion("family_name in", values, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameNotIn(List<String> values) {
            addCriterion("family_name not in", values, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameBetween(String value1, String value2) {
            addCriterion("family_name between", value1, value2, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameNotBetween(String value1, String value2) {
            addCriterion("family_name not between", value1, value2, "familyName");
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