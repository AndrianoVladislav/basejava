package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r = new Resume("uuid1", "Grigory Kislin");
        ContactType phoneNumber = ContactType.PHONE_NUMBER;
        r.getContact().put(phoneNumber, "���.: +7(921) 855-0482");
        ContactType skype = ContactType.SKYPE;
        r.getContact().put(skype, "skype: grigory.kislin");
        ContactType mail = ContactType.MAIL;
        r.getContact().put(mail, "�����: gkislin@yandex.ru");
        ContactType linkedin = ContactType.LINKEDIN;
        r.getContact().put(linkedin, "������� LinkedIn");
        ContactType github = ContactType.GITHUB;
        r.getContact().put(github, "������� GitHub");
        ContactType statckoverflow = ContactType.STATCKOVERFLOW;
        r.getContact().put(statckoverflow, "������� Stackoverflow");
        ContactType homePage = ContactType.HOME_PAGE;
        r.getContact().put(homePage, "�������� ��������");
        for (String type : r.getContact().values()) {
            System.out.println(type);
        }

        SectionType personal = SectionType.PERSONAL;
        SectionText personalText = new SectionText("������������� ����� ���, ������� ������, ������������, ��������������. ������ ���� � �����������.");
        r.getSection().put(personal, personalText);

        SectionType objective = SectionType.OBJECTIVE;
        SectionText objectiveText = new SectionText("������� ���������� � �������������� �������� �� Java Web � Enterprise �����������.");
        r.getSection().put(objective, objectiveText);

        SectionType achievement = SectionType.ACHIEVEMENT;
        List<String> list = new ArrayList<>();
        String text = "\n����������� ������� � �������� ���������� Java �������� ��� ��������� ����������: ���������� �������� �� ����� Spring Cloud/������������, ������� ����������� ����������� ����������� �� Spring Boot, ������� � ������� ��� �� Play-2, �������������� Spring Boot + Vaadin ������ ��� ����������� DIY ����";
        list.add(text);
        text = "\n� 2013 ����: ���������� �������� \"���������� Web ����������\",\"Java Enterprise\", \"�������������� maven. ���������������. XML (JAXB/StAX). ��� ������� (JAX-RS/SOAP). ��������� �������������� (JMS/AKKA)\". ����������� ������ ���������� � ������� ��������. ����� 3500 �����������.";
        list.add(text);
        text = "\n���������� ������������� �������������� ��� ������ ��������� ���������� ��������� Wrike. ���������� � Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.";
        list.add(text);
        text = "\n����������� �������� ���������� � ����������� ���������� ERP ������� River BPM. ���������� � 1�, Bonita BPM, CMIS, LDAP. ���������� ���������� ���������� ���������� �� �����: Scala/Play/Anorm/JQuery. ���������� SSO �������������� � ����������� ��������� ERP �������, ���������� CIFS/SMB java �������.";
        list.add(text);
        text = "\n���������� c ���� Rich Internet Application ���������� �� ����� ���������� JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock ��� ���������������� ���������.";
        list.add(text);
        text = "\n�������� JavaEE ���������� ��� ����������������� �������������� �����-��������� �������� (SOA-base �����������, JAX-WS, JMS, AS Glassfish). ���� ���������� �������� � ���������� � ��������� ����� ������� ����������� Nagios. ���������� ������ ������� ��� ����������������� � ����������� ������� �� JMX (Jython/ Django).";
        list.add(text);
        text = "\n���������� ���������� �� ������ �������� ���� �������� ��������� ������� ������ (Cyberplat, Eport, Chronopay, ��������), ������c���(Erip, Osmp) � ���������.";
        list.add(text);
        SectionList achievementList = new SectionList(list);
        r.getSection().put(achievement, achievementList);

        SectionType qualifications = SectionType.QUALIFICATIONS;
        list.clear();
        text = "\nJEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2";
        list.add(text);
        text = "\nVersion control: Subversion, Git, Mercury, ClearCase, Perforce";
        list.add(text);
        text = "\nDB: PostgreSQL(������������, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB\n";
        list.add(text);
        text = "\nLanguages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy";
        list.add(text);
        text = "\nXML/XSD/XSLT, SQL, C/C++, Unix shell scripts";
        list.add(text);
        text = "\nJava Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).";
        list.add(text);
        text = "\nPython: Django.";
        list.add(text);
        text = "\nJavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js";
        list.add(text);
        text = "\nScala: SBT, Play2, Specs2, Anorm, Spray, Akka";
        list.add(text);
        text = "\n����������: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.";
        list.add(text);
        text = "\n�����������: Maven + plugin development, Gradle, ��������� Ngnix";
        list.add(text);
        text = "\n����������������� Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer";
        list.add(text);
        text = "\n�������� ������ � ���� ���������� ��������� ���, SOA, �������� ���������������, ������������� ��������, UML, ��������������� ����������������";
        list.add(text);
        text = "\n������ �������, ���������� \"upper intermediate\"";
        list.add(text);
        SectionList qualificationsList = new SectionList(list);
        r.getSection().put(qualifications, qualificationsList);

        SectionType experience = SectionType.EXPERIENCE;
        List<Organization> list2 = new ArrayList<>();
        Organization organization = new Organization("09/1997", "01/2005", "Alcatel", "������� �� ����������� � ������������ ������������", "������������, �������, ��������� �� �������� ���������� ������� Alcatel 1000 S12 (CHILL, ASM).");
        list2.add(organization);
        organization = new Organization("01/2005", "02/2007", "Siemens AG", "����������� ��", "���������� �������������� ������, �������������� �����������, ���������� � ������� �� �� ��������� IN ��������� Siemens @vantage (Java, Unix).");
        list2.add(organization);
        organization = new Organization("03/2007", "06/2008", "Enkata", "����������� ��", "���������� ���������� (Eclipse RCP) � ��������� (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) ������ ����������� J2EE ���������� (OLAP, Data mining).");
        list2.add(organization);
        organization = new Organization("06/2008", "12/2010", "Yota", "������� ����������", "������ � ������������� Java EE ���������� ��� ������ \"��������� �������\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). ���������� �����������������, ���������� � ����������� ����������. ���������� online JMX ������� (Python/ Jython, Django, ExtJS)");
        list2.add(organization);
        organization = new Organization("12/2010", "04/2012", "Luxoft (Deutsche Bank)", "������� �����������", "������� � ������� Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). ���������� ���������� � ��������� ����� CRM. ���������� RIA-���������� ��� �����������������, ����������� � ������� ����������� � ������� ���������������� ���������. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");
        list2.add(organization);
        organization = new Organization("04/2012", "10/2014", "RIT Center", "Java ����������", "����������� �������� ���������� ������� ERP ��� ������ ���������: �������� ��������, ���������������, ������� CI (Jenkins), �������� ���� (������������ Flyway), ���������������� ������� (pgBoucer, Nginx), AAA via SSO. ����������� �� � ��������� ����� �������. ���������� �������������� ��������: CMIS, BPMN2, 1C (WebServices), �������� ������ ���������� (�����, ������� � pdf, doc, html). ���������� Alfresco JLAN ��� online �������������� �� �������� ���������� MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");
        list2.add(organization);
        organization = new Organization("10/2014", "01/2016", "Wrike", "������� ����������� (backend)", "�������������� � ���������� ������ ��������� ���������� ��������� Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). ������������� ��������������, ����������� �� OAuth1, OAuth2, JWT SSO.");
        list2.add(organization);
        organization = new Organization("10/2013", "������", "Java Online Projects", "����� �������.", "��������, ����������� � ���������� Java ������ �������� � ����������.");
        list2.add(organization);
        OrganizationSection experienceList = new OrganizationSection(list2);
        r.getSection().put(experience, experienceList);

        SectionType education = SectionType.EDUCATION;
        list2.clear();
        organization = new Organization("09/1984", "06/1987", "������� ������-����������� ����� ��� ����", "�������� � ��������", null);
        list2.add(organization);
        organization = new Organization("09/1987", "07/1993", "�����-������������� ������������ ����������������� ����������� �������������� ����������, �������� � ������", "������� (����������� Fortran, C)", null);
        list2.add(organization);
        organization = new Organization("09/1993", "07/1996", "�����-������������� ������������ ����������������� ����������� �������������� ����������, �������� � ������", "����������� (����������� �, �++)", null);
        list2.add(organization);
        organization = new Organization("09/1997", "03/1998", "Alcatel", "6 ������� �������� �������� ���������� ����� (������)", null);
        list2.add(organization);
        organization = new Organization("01/2005", "04/2005", "Siemens AG", "3 ������ �������� ��������� IN ����� (������)", null);
        list2.add(organization);
        organization = new Organization("03/2011", "04/2011", "Luxoft", "���� '��������-��������������� ������ ��. �������������� ������������� �� UML.'", null);
        list2.add(organization);
        organization = new Organization("03/2013", "05/2013", "Coursera", "'Functional Programming Principles in Scala' by Martin Odersky", null);
        list2.add(organization);
        OrganizationSection educationList = new OrganizationSection(list2);
        r.getSection().put(education, educationList);

        for (Section type : r.getSection().values()) {
            System.out.println();
            System.out.println(type.toString());
        }
    }
}

