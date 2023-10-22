# Task 1 - ETL process

## Create data model with following fields:
    "id": int, // id of sport
    "name": string // sport name
### Create Reactive Repository

### Create Setup class with following functionality: 
 - 3.1. Requests sports from https://sports.api.decathlon.com/sports 
 - 3.2. Parse Json Response using reactive pipelines and save objects using reactive repository


# Task 2 - API for Sports

## Implement the following API methods using Router Functions:
    - POST /api/v1/sport/{sportname]} // create sport with name. make sure that you correctly cach exceptions if sport with provided name already exist
    - GET /api/v1/sport?q=... //search sports by name
## Implement methods in reactive repository with methods to support API above


# Task 3 - Refactor ETL process using backpressure (1 Point)

## Modify our ETL implementation to apply backpressure. Tell the upstream to only send 20 elements at a time by using request().

## Log operations to see that request(20) is calles, followed by 20 onNext() calls, then request(20) again and so on.

