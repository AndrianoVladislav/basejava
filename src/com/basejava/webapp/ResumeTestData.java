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
        TextSection personalText = new TextSection("������������� ����� ���, ������� ������, ������������, ��������������. ������ ���� � �����������.");
        r.getSection().put(personal, personalText);

        SectionType objective = SectionType.OBJECTIVE;
        TextSection objectiveText = new TextSection("������� ���������� � �������������� �������� �� Java Web � Enterprise �����������.");
        r.getSection().put(objective, objectiveText);

        SectionType achievement = SectionType.ACHIEVEMENT;
        List<String> list = new ArrayList<>();
        doSection(list, "����������� ������� � �������� ���������� Java �������� ��� ��������� ����������: ���������� �������� �� ����� Spring Cloud/������������, ������� ����������� ����������� ����������� �� Spring Boot, ������� � ������� ��� �� Play-2, �������������� Spring Boot + Vaadin ������ ��� ����������� DIY ����");
        doSection(list, "\n� 2013 ����: ���������� �������� \"���������� Web ����������\",\"Java Enterprise\", \"�������������� maven. ���������������. XML (JAXB/StAX). ��� ������� (JAX-RS/SOAP). ��������� �������������� (JMS/AKKA)\". ����������� ������ ���������� � ������� ��������. ����� 3500 �����������.");
        doSection(list, "\n���������� ������������� �������������� ��� ������ ��������� ���������� ��������� Wrike. ���������� � Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        doSection(list, "\n����������� �������� ���������� � ����������� ���������� ERP ������� River BPM. ���������� � 1�, Bonita BPM, CMIS, LDAP. ���������� ���������� ���������� ���������� �� �����: Scala/Play/Anorm/JQuery. ���������� SSO �������������� � ����������� ��������� ERP �������, ���������� CIFS/SMB java �������.");
        doSection(list, "\n���������� c ���� Rich Internet Application ���������� �� ����� ���������� JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock ��� ���������������� ���������.");
        doSection(list, "\n�������� JavaEE ���������� ��� ����������������� �������������� �����-��������� �������� (SOA-base �����������, JAX-WS, JMS, AS Glassfish). ���� ���������� �������� � ���������� � ��������� ����� ������� ����������� Nagios. ���������� ������ ������� ��� ����������������� � ����������� ������� �� JMX (Jython/ Django).");
        doSection(list, "\n���������� ���������� �� ������ �������� ���� �������� ��������� ������� ������ (Cyberplat, Eport, Chronopay, ��������), ������c���(Erip, Osmp) � ���������.");
        ListSection achievementList = new ListSection(list);
        r.getSection().put(achievement, achievementList);

        SectionType qualifications = SectionType.QUALIFICATIONS;
        List<String> list2 = new ArrayList<>();
        doSection(list2, "\nJEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        doSection(list2, "\nVersion control: Subversion, Git, Mercury, ClearCase, Perforce");
        doSection(list2, "\nDB: PostgreSQL(������������, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");
        doSection(list2, "\nLanguages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        doSection(list2, "\nXML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        doSection(list2, "\nJava Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        doSection(list2, "\nPython: Django.");
        doSection(list2, "\nJavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        doSection(list2, "\nScala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        doSection(list2, "\n����������: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        doSection(list2, "\n�����������: Maven + plugin development, Gradle, ��������� Ngnix");
        doSection(list2, "\n����������������� Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer");
        doSection(list2, "\n�������� ������ � ���� ���������� ��������� ���, SOA, �������� ���������������, ������������� ��������, UML, ��������������� ����������������");
        doSection(list2, "\n������ �������, ���������� \"upper intermediate\"");
        ListSection qualificationsList = new ListSection(list2);
        r.getSection().put(qualifications, qualificationsList);

        SectionType experience = SectionType.EXPERIENCE;
        List<Organization> listOrganization = new ArrayList<>();
        doOrganization(listOrganization, "09/1997", "01/2005", "Alcatel", "������� �� ����������� � ������������ ������������", "������������, �������, ��������� �� �������� ���������� ������� Alcatel 1000 S12 (CHILL, ASM).");
        doOrganization(listOrganization, "01/2005", "02/2007", "Siemens AG", "����������� ��", "���������� �������������� ������, �������������� �����������, ���������� � ������� �� �� ��������� IN ��������� Siemens @vantage (Java, Unix).");
        doOrganization(listOrganization, "03/2007", "06/2008", "Enkata", "����������� ��", "���������� ���������� (Eclipse RCP) � ��������� (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) ������ ����������� J2EE ���������� (OLAP, Data mining).");
        doOrganization(listOrganization, "06/2008", "12/2010", "Yota", "������� ����������", "������ � ������������� Java EE ���������� ��� ������ \"��������� �������\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). ���������� �����������������, ���������� � ����������� ����������. ���������� online JMX ������� (Python/ Jython, Django, ExtJS)");
        doOrganization(listOrganization, "12/2010", "04/2012", "Luxoft (Deutsche Bank)", "������� �����������", "������� � ������� Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). ���������� ���������� � ��������� ����� CRM. ���������� RIA-���������� ��� �����������������, ����������� � ������� ����������� � ������� ���������������� ���������. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");
        doOrganization(listOrganization, "04/2012", "10/2014", "RIT Center", "Java ����������", "����������� �������� ���������� ������� ERP ��� ������ ���������: �������� ��������, ���������������, ������� CI (Jenkins), �������� ���� (������������ Flyway), ���������������� ������� (pgBoucer, Nginx), AAA via SSO. ����������� �� � ��������� ����� �������. ���������� �������������� ��������: CMIS, BPMN2, 1C (WebServices), �������� ������ ���������� (�����, ������� � pdf, doc, html). ���������� Alfresco JLAN ��� online �������������� �� �������� ���������� MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");
        doOrganization(listOrganization, "10/2014", "01/2016", "Wrike", "������� ����������� (backend)", "�������������� � ���������� ������ ��������� ���������� ��������� Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). ������������� ��������������, ����������� �� OAuth1, OAuth2, JWT SSO.");
        doOrganization(listOrganization, "10/2013", "������", "Java Online Projects", "����� �������.", "��������, ����������� � ���������� Java ������ �������� � ����������.");
        OrganizationSection experienceList = new OrganizationSection(listOrganization);
        r.getSection().put(experience, experienceList);

        SectionType education = SectionType.EDUCATION;
        List<Organization> listOrganization2 = new ArrayList<>();
        doOrganization(listOrganization2, "09/1984", "06/1987", "������� ������-����������� ����� ��� ����", "�������� � ��������", null);
        List<Period> listPeriod = new ArrayList<>();
        Period period = new Period("09/1987", "07/1993", "������� (����������� Fortran, C)", null);
        listPeriod.add(period);
        period = new Period("09/1993", "07/1996", "����������� (����������� �, �++)", null);
        listPeriod.add(period);
        Organization organization = new Organization("�����-������������� ������������ ����������������� ����������� �������������� ����������, �������� � ������", listPeriod);
        listOrganization2.add(organization);
        doOrganization(listOrganization2, "09/1997", "03/1998", "Alcatel", "6 ������� �������� �������� ���������� ����� (������)", null);
        doOrganization(listOrganization2, "01/2005", "04/2005", "Siemens AG", "3 ������ �������� ��������� IN ����� (������)", null);
        doOrganization(listOrganization2, "03/2011", "04/2011", "Luxoft", "���� '��������-��������������� ������ ��. �������������� ������������� �� UML.'", null);
        doOrganization(listOrganization2, "03/2013", "05/2013", "Coursera", "'Functional Programming Principles in Scala' by Martin Odersky", null);
        OrganizationSection educationList = new OrganizationSection(listOrganization2);
        r.getSection().put(education, educationList);

        for (AbstractSection type : r.getSection().values()) {
            System.out.println();
            System.out.println(type.toString());
        }
    }

    private static void doOrganization(List<Organization> list, String startDate, String endDate, String name, String title, String description) {
        List<Period> listPeriod = new ArrayList<>();
        Period period = new Period(startDate, endDate, title, description);
        listPeriod.add(period);
        Organization organization = new Organization(name, listPeriod);
        list.add(organization);
    }

    private static void doSection(List<String> list, String text){
        list.add(text);
    }
}

