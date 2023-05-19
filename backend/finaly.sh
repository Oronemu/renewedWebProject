rm -rf ~/JakartaEE/glassfish7/glassfish/domains/domain1/applications/*
rm -rf ~/JakartaEE/glassfish7/glassfish/domains/domain1/generated/*
rm -rf ~/JakartaEE/glassfish7/glassfish/domains/domain1/imq/

~/JakartaEE/glassfish7/bin/asadmin start-domain

~/JakartaEE/glassfish7/bin/asadmin deploy --force=true ./target/habr.war
~/JakartaEE/glassfish7/bin/asadmin deploy --force=true ./../token/target/token.war