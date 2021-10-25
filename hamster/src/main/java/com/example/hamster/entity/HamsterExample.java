package com.example.hamster.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HamsterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HamsterExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andHamsterNameIsNull() {
            addCriterion("hamster_name is null");
            return (Criteria) this;
        }

        public Criteria andHamsterNameIsNotNull() {
            addCriterion("hamster_name is not null");
            return (Criteria) this;
        }

        public Criteria andHamsterNameEqualTo(String value) {
            addCriterion("hamster_name =", value, "hamsterName");
            return (Criteria) this;
        }

        public Criteria andHamsterNameNotEqualTo(String value) {
            addCriterion("hamster_name <>", value, "hamsterName");
            return (Criteria) this;
        }

        public Criteria andHamsterNameGreaterThan(String value) {
            addCriterion("hamster_name >", value, "hamsterName");
            return (Criteria) this;
        }

        public Criteria andHamsterNameGreaterThanOrEqualTo(String value) {
            addCriterion("hamster_name >=", value, "hamsterName");
            return (Criteria) this;
        }

        public Criteria andHamsterNameLessThan(String value) {
            addCriterion("hamster_name <", value, "hamsterName");
            return (Criteria) this;
        }

        public Criteria andHamsterNameLessThanOrEqualTo(String value) {
            addCriterion("hamster_name <=", value, "hamsterName");
            return (Criteria) this;
        }

        public Criteria andHamsterNameLike(String value) {
            addCriterion("hamster_name like", value, "hamsterName");
            return (Criteria) this;
        }

        public Criteria andHamsterNameNotLike(String value) {
            addCriterion("hamster_name not like", value, "hamsterName");
            return (Criteria) this;
        }

        public Criteria andHamsterNameIn(List<String> values) {
            addCriterion("hamster_name in", values, "hamsterName");
            return (Criteria) this;
        }

        public Criteria andHamsterNameNotIn(List<String> values) {
            addCriterion("hamster_name not in", values, "hamsterName");
            return (Criteria) this;
        }

        public Criteria andHamsterNameBetween(String value1, String value2) {
            addCriterion("hamster_name between", value1, value2, "hamsterName");
            return (Criteria) this;
        }

        public Criteria andHamsterNameNotBetween(String value1, String value2) {
            addCriterion("hamster_name not between", value1, value2, "hamsterName");
            return (Criteria) this;
        }

        public Criteria andHamsterHeightIsNull() {
            addCriterion("hamster_height is null");
            return (Criteria) this;
        }

        public Criteria andHamsterHeightIsNotNull() {
            addCriterion("hamster_height is not null");
            return (Criteria) this;
        }

        public Criteria andHamsterHeightEqualTo(BigDecimal value) {
            addCriterion("hamster_height =", value, "hamsterHeight");
            return (Criteria) this;
        }

        public Criteria andHamsterHeightNotEqualTo(BigDecimal value) {
            addCriterion("hamster_height <>", value, "hamsterHeight");
            return (Criteria) this;
        }

        public Criteria andHamsterHeightGreaterThan(BigDecimal value) {
            addCriterion("hamster_height >", value, "hamsterHeight");
            return (Criteria) this;
        }

        public Criteria andHamsterHeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hamster_height >=", value, "hamsterHeight");
            return (Criteria) this;
        }

        public Criteria andHamsterHeightLessThan(BigDecimal value) {
            addCriterion("hamster_height <", value, "hamsterHeight");
            return (Criteria) this;
        }

        public Criteria andHamsterHeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hamster_height <=", value, "hamsterHeight");
            return (Criteria) this;
        }

        public Criteria andHamsterHeightIn(List<BigDecimal> values) {
            addCriterion("hamster_height in", values, "hamsterHeight");
            return (Criteria) this;
        }

        public Criteria andHamsterHeightNotIn(List<BigDecimal> values) {
            addCriterion("hamster_height not in", values, "hamsterHeight");
            return (Criteria) this;
        }

        public Criteria andHamsterHeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hamster_height between", value1, value2, "hamsterHeight");
            return (Criteria) this;
        }

        public Criteria andHamsterHeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hamster_height not between", value1, value2, "hamsterHeight");
            return (Criteria) this;
        }

        public Criteria andHamsterWeightIsNull() {
            addCriterion("hamster_weight is null");
            return (Criteria) this;
        }

        public Criteria andHamsterWeightIsNotNull() {
            addCriterion("hamster_weight is not null");
            return (Criteria) this;
        }

        public Criteria andHamsterWeightEqualTo(BigDecimal value) {
            addCriterion("hamster_weight =", value, "hamsterWeight");
            return (Criteria) this;
        }

        public Criteria andHamsterWeightNotEqualTo(BigDecimal value) {
            addCriterion("hamster_weight <>", value, "hamsterWeight");
            return (Criteria) this;
        }

        public Criteria andHamsterWeightGreaterThan(BigDecimal value) {
            addCriterion("hamster_weight >", value, "hamsterWeight");
            return (Criteria) this;
        }

        public Criteria andHamsterWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hamster_weight >=", value, "hamsterWeight");
            return (Criteria) this;
        }

        public Criteria andHamsterWeightLessThan(BigDecimal value) {
            addCriterion("hamster_weight <", value, "hamsterWeight");
            return (Criteria) this;
        }

        public Criteria andHamsterWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hamster_weight <=", value, "hamsterWeight");
            return (Criteria) this;
        }

        public Criteria andHamsterWeightIn(List<BigDecimal> values) {
            addCriterion("hamster_weight in", values, "hamsterWeight");
            return (Criteria) this;
        }

        public Criteria andHamsterWeightNotIn(List<BigDecimal> values) {
            addCriterion("hamster_weight not in", values, "hamsterWeight");
            return (Criteria) this;
        }

        public Criteria andHamsterWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hamster_weight between", value1, value2, "hamsterWeight");
            return (Criteria) this;
        }

        public Criteria andHamsterWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hamster_weight not between", value1, value2, "hamsterWeight");
            return (Criteria) this;
        }

        public Criteria andHamsterBirthdayIsNull() {
            addCriterion("hamster_birthday is null");
            return (Criteria) this;
        }

        public Criteria andHamsterBirthdayIsNotNull() {
            addCriterion("hamster_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andHamsterBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("hamster_birthday =", value, "hamsterBirthday");
            return (Criteria) this;
        }

        public Criteria andHamsterBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("hamster_birthday <>", value, "hamsterBirthday");
            return (Criteria) this;
        }

        public Criteria andHamsterBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("hamster_birthday >", value, "hamsterBirthday");
            return (Criteria) this;
        }

        public Criteria andHamsterBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hamster_birthday >=", value, "hamsterBirthday");
            return (Criteria) this;
        }

        public Criteria andHamsterBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("hamster_birthday <", value, "hamsterBirthday");
            return (Criteria) this;
        }

        public Criteria andHamsterBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hamster_birthday <=", value, "hamsterBirthday");
            return (Criteria) this;
        }

        public Criteria andHamsterBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("hamster_birthday in", values, "hamsterBirthday");
            return (Criteria) this;
        }

        public Criteria andHamsterBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("hamster_birthday not in", values, "hamsterBirthday");
            return (Criteria) this;
        }

        public Criteria andHamsterBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hamster_birthday between", value1, value2, "hamsterBirthday");
            return (Criteria) this;
        }

        public Criteria andHamsterBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hamster_birthday not between", value1, value2, "hamsterBirthday");
            return (Criteria) this;
        }

        public Criteria andHamsterKindIsNull() {
            addCriterion("hamster_kind is null");
            return (Criteria) this;
        }

        public Criteria andHamsterKindIsNotNull() {
            addCriterion("hamster_kind is not null");
            return (Criteria) this;
        }

        public Criteria andHamsterKindEqualTo(String value) {
            addCriterion("hamster_kind =", value, "hamsterKind");
            return (Criteria) this;
        }

        public Criteria andHamsterKindNotEqualTo(String value) {
            addCriterion("hamster_kind <>", value, "hamsterKind");
            return (Criteria) this;
        }

        public Criteria andHamsterKindGreaterThan(String value) {
            addCriterion("hamster_kind >", value, "hamsterKind");
            return (Criteria) this;
        }

        public Criteria andHamsterKindGreaterThanOrEqualTo(String value) {
            addCriterion("hamster_kind >=", value, "hamsterKind");
            return (Criteria) this;
        }

        public Criteria andHamsterKindLessThan(String value) {
            addCriterion("hamster_kind <", value, "hamsterKind");
            return (Criteria) this;
        }

        public Criteria andHamsterKindLessThanOrEqualTo(String value) {
            addCriterion("hamster_kind <=", value, "hamsterKind");
            return (Criteria) this;
        }

        public Criteria andHamsterKindLike(String value) {
            addCriterion("hamster_kind like", value, "hamsterKind");
            return (Criteria) this;
        }

        public Criteria andHamsterKindNotLike(String value) {
            addCriterion("hamster_kind not like", value, "hamsterKind");
            return (Criteria) this;
        }

        public Criteria andHamsterKindIn(List<String> values) {
            addCriterion("hamster_kind in", values, "hamsterKind");
            return (Criteria) this;
        }

        public Criteria andHamsterKindNotIn(List<String> values) {
            addCriterion("hamster_kind not in", values, "hamsterKind");
            return (Criteria) this;
        }

        public Criteria andHamsterKindBetween(String value1, String value2) {
            addCriterion("hamster_kind between", value1, value2, "hamsterKind");
            return (Criteria) this;
        }

        public Criteria andHamsterKindNotBetween(String value1, String value2) {
            addCriterion("hamster_kind not between", value1, value2, "hamsterKind");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
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