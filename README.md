# LDAP---Using-LdapTemplate

To implement LDAP in spring we need to configure LdapTemplate, that's like a contextSource for configuring a connect with LDAP Server.
in this case i used EMBEDDED LDAP SERVER.

#Attention

I just sharing part of code configure LDAP, please kindly more explore for the other source what you need.

#Explanation

1. Include your dependencies for this case we need include dependencies for LDAP Test and UnboundId
2. If we want to use a EMBEDDED LDAP SERVER, just configure your properties to include a ldap server but if we want to connect with
   LDAP Server just configure a LdapTemplate.

if any an issue please sharing, due to my knowledge somewhat limited
