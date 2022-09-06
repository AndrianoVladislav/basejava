package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r = new Resume("uuid1", "Grigory Kislin");
        ContactType phoneNumber = ContactType.PHONE_NUMBER;
        r.getContact().put(phoneNumber, "Тел.: +7(921) 855-0482");
        ContactType skype = ContactType.SKYPE;
        r.getContact().put(skype, "skype: grigory.kislin");
        ContactType mail = ContactType.MAIL;
        r.getContact().put(mail, "Почта: gkislin@yandex.ru");
        ContactType linkedin = ContactType.LINKEDIN;
        r.getContact().put(linkedin, "Профиль LinkedIn");
        ContactType github = ContactType.GITHUB;
        r.getContact().put(github, "Профиль GitHub");
        ContactType statckoverflow = ContactType.STATCKOVERFLOW;
        r.getContact().put(statckoverflow, "Профиль Stackoverflow");
        ContactType homePage = ContactType.HOME_PAGE;
        r.getContact().put(homePage, "Домашняя страница");
        for (String type : r.getContact().values()) {
            System.out.println(type);
        }

        SectionType personal = SectionType.PERSONAL;
        SectionText personalText = new SectionText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        r.getSection().put(personal, personalText);

        SectionType objective = SectionType.OBJECTIVE;
        SectionText objectiveText = new SectionText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям.");
        r.getSection().put(objective, objectiveText);

        SectionType achievement = SectionType.ACHIEVEMENT;
        List<String> list = new ArrayList<>();
        String text = "\nОрганизация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет";
        list.add(text);
        text = "\nС 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.";
        list.add(text);
        text = "\nРеализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.";
        list.add(text);
        text = "\nНалаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.";
        list.add(text);
        text = "\nРеализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.";
        list.add(text);
        text = "\nСоздание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).";
        list.add(text);
        text = "\nРеализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.";
        list.add(text);
        SectionList achievementList = new SectionList(list);
        r.getSection().put(achievement, achievementList);

        SectionType qualifications = SectionType.QUALIFICATIONS;
        list.clear();
        text = "\nJEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2";
        list.add(text);
        text = "\nVersion control: Subversion, Git, Mercury, ClearCase, Perforce";
        list.add(text);
        text = "\nDB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB\n";
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
        text = "\nТехнологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.";
        list.add(text);
        text = "\nИнструменты: Maven + plugin development, Gradle, настройка Ngnix";
        list.add(text);
        text = "\nАдминистрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer";
        list.add(text);
        text = "\nОтличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования";
        list.add(text);
        text = "\nРодной русский, английский \"upper intermediate\"";
        list.add(text);
        SectionList qualificationsList = new SectionList(list);
        r.getSection().put(qualifications, qualificationsList);

        SectionType experience = SectionType.EXPERIENCE;
        List<Organization> list2 = new ArrayList<>();
        Organization organization = new Organization("09/1997", "01/2005", "Alcatel", "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        list2.add(organization);
        organization = new Organization("01/2005", "02/2007", "Siemens AG", "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        list2.add(organization);
        organization = new Organization("03/2007", "06/2008", "Enkata", "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).");
        list2.add(organization);
        organization = new Organization("06/2008", "12/2010", "Yota", "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        list2.add(organization);
        organization = new Organization("12/2010", "04/2012", "Luxoft (Deutsche Bank)", "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");
        list2.add(organization);
        organization = new Organization("04/2012", "10/2014", "RIT Center", "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");
        list2.add(organization);
        organization = new Organization("10/2014", "01/2016", "Wrike", "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        list2.add(organization);
        organization = new Organization("10/2013", "Сейчас", "Java Online Projects", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.");
        list2.add(organization);
        OrganizationSection experienceList = new OrganizationSection(list2);
        r.getSection().put(experience, experienceList);

        SectionType education = SectionType.EDUCATION;
        list2.clear();
        organization = new Organization("09/1984", "06/1987", "Заочная физико-техническая школа при МФТИ", "Закончил с отличием", null);
        list2.add(organization);
        organization = new Organization("09/1987", "07/1993", "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "Инженер (программист Fortran, C)", null);
        list2.add(organization);
        organization = new Organization("09/1993", "07/1996", "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "Аспирантура (программист С, С++)", null);
        list2.add(organization);
        organization = new Organization("09/1997", "03/1998", "Alcatel", "6 месяцев обучения цифровым телефонным сетям (Москва)", null);
        list2.add(organization);
        organization = new Organization("01/2005", "04/2005", "Siemens AG", "3 месяца обучения мобильным IN сетям (Берлин)", null);
        list2.add(organization);
        organization = new Organization("03/2011", "04/2011", "Luxoft", "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'", null);
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

