
FROM amazoncorretto:17-alpine-jdk
MAINTAINER lucapagnossin
COPY target/LucaPagnossinPortfolioAPI.jar LucaPagnossinPortfolioAPI.jar
ENTRYPOINT ["java","-jar","/LucaPagnossinPortfolioAPI.jar"]