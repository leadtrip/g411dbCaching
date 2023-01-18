Testing Grails 4 database caching.

Go to http://localhost:10060/car/testCaching & reload a few times, check the logs which are set up to log both cache and database access attempts.

Accessing the testCaching view results in a number of calls to a data service which fetches a domain using a data service created method, a dynamic finder and a critiera query all of which should be setup for caching either in the Car domain class or on the method call.

http://localhost:10060/carManufacturer/testCaching tests caching with an abstract domain class