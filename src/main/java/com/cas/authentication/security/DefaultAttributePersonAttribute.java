package com.cas.authentication.security;

import org.jasig.services.persondir.IPersonAttributes;
import org.jasig.services.persondir.support.CaseInsensitiveAttributeNamedPersonImpl;
import org.jasig.services.persondir.support.CaseInsensitiveNamedPersonImpl;
import org.jasig.services.persondir.support.MultivaluedPersonAttributeUtils;
import org.jasig.services.persondir.support.jdbc.AbstractJdbcPersonAttributeDao;
import org.jasig.services.persondir.support.jdbc.ColumnMapParameterizedRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultAttributePersonAttribute extends AbstractJdbcPersonAttributeDao<Map<String, Object>> {
	private static final ParameterizedRowMapper<Map<String, Object>> MAPPER = new ColumnMapParameterizedRowMapper(true);
	private static final JdbcTemplate JDBC_TEMPLATE = new JdbcTemplate();
	
	public DefaultAttributePersonAttribute(DataSource ds, String sql) {
		super(ds, sql);
		JDBC_TEMPLATE.setDataSource(ds);
	}

	@Override
	protected ParameterizedRowMapper<Map<String, Object>> getRowMapper() {
		return MAPPER;
	}
	

	@Override
	protected List<IPersonAttributes> parseAttributeMapFromResults(List<Map<String, Object>> queryResults, String queryUserName) {
		List<IPersonAttributes> peopleAttributes = new ArrayList<IPersonAttributes>(queryResults.size());
		for (Map<String, Object> queryResult : queryResults) {
			Map<String, List<Object>> multivaluedQueryResult = MultivaluedPersonAttributeUtils.toMultivaluedMap(queryResult);
			IPersonAttributes person;
			if (queryUserName != null) {
				person = new CaseInsensitiveNamedPersonImpl(queryUserName,multivaluedQueryResult);
			} else {
				String userNameAttribute = getConfiguredUserNameAttribute();
				person = new CaseInsensitiveAttributeNamedPersonImpl(userNameAttribute, multivaluedQueryResult);
			}
			peopleAttributes.add(person);
		}

		return peopleAttributes;
	}
}