/*
 *  Copyright 2009 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class SelectByExampleWithoutBLOBsElementGenerator extends
        AbstractXmlElementGenerator {

    public SelectByExampleWithoutBLOBsElementGenerator() {
        super();
    }

    @Override
    public void addElements(XmlElement parentElement) {
        String fqjt = introspectedTable.getExampleType();

        XmlElement answer = new XmlElement("select"); //$NON-NLS-1$

        answer.addAttribute(new Attribute("id", //$NON-NLS-1$
                introspectedTable.getSelectByExampleStatementId()));
        answer.addAttribute(new Attribute(
                "resultMap", introspectedTable.getBaseResultMapId())); //$NON-NLS-1$
        //TODO �޸Ĳ�ѯ����
        FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();
        answer.addAttribute(new Attribute("parameterType", parameterType.getFullyQualifiedName())); //$NON-NLS-1$

        context.getCommentGenerator().addComment(answer);

        answer.addElement(new TextElement("select")); //$NON-NLS-1$
        
        XmlElement ifElement = new XmlElement("if"); //$NON-NLS-1$
        //TODO ��ѯȥ��distinct
//        ifElement.addAttribute(new Attribute("test", "distinct")); //$NON-NLS-1$ //$NON-NLS-2$
//        ifElement.addElement(new TextElement("distinct")); //$NON-NLS-1$
//        answer.addElement(ifElement);

        StringBuilder sb = new StringBuilder();
        if (stringHasValue(introspectedTable
                .getSelectByExampleQueryId())) {
            sb.append('\'');
            sb.append(introspectedTable.getSelectByExampleQueryId());
            sb.append("' as QUERYID,"); //$NON-NLS-1$
            answer.addElement(new TextElement(sb.toString()));
        }
        answer.addElement(getBaseColumnListElement());

        sb.setLength(0);
        sb.append("from "); //$NON-NLS-1$
        sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        answer.addElement((new TextElement(sb.toString())));
//        answer.addElement(getExampleIncludeElement());

//        ifElement = new XmlElement("if"); //$NON-NLS-1$
//        ifElement.addAttribute(new Attribute("test", "orderByClause != null")); //$NON-NLS-1$ //$NON-NLS-2$
//        ifElement.addElement(new TextElement("order by ${orderByClause}")); //$NON-NLS-1$
//        answer.addElement(ifElement);

        //TODO ����selectByParam��ѯ����
        XmlElement whereElement = new XmlElement("where");
        for (IntrospectedColumn introspectedColumn : introspectedTable.getNonPrimaryKeyColumns()) {
	        XmlElement isNotNullElement = new XmlElement("if"); 
	        sb.setLength(0);
	        sb.append(introspectedColumn.getJavaProperty());
	        sb.append(" != null");
	        isNotNullElement.addAttribute(new Attribute("test", sb.toString())); 
	
	        sb.setLength(0);
	        sb.append("AND ");
	        sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
	        sb.append(" = "); 
	        sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
	
	        isNotNullElement.addElement(new TextElement(sb.toString()));
	        
	        whereElement.addElement(isNotNullElement);
        }
        
        answer.addElement(whereElement);
        
        
        if (context.getPlugins().sqlMapSelectByExampleWithoutBLOBsElementGenerated(answer,introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
