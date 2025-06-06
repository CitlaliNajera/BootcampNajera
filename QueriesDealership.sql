#Queries for dealership

#1
SELECT *
FROM vehicles; 
#2
SELECT vehicles.Vin,Name, DealershipID
FROM vehicles 
JOIN inventory ON inventory.Vin = vehicles.Vin 
WHERE DealershipID = 1 ; 
#3
SELECT *
FROM vehicles
WHERE Vin=10005;
#4
SELECT dealerships.Name, dealerships.Address,vehicles.Name AS VehicleName, vehicles.Vin
FROM dealerships
JOIN inventory ON inventory.DealershipID = dealerships.DealershipID
JOIN vehicles ON vehicles.Vin = inventory.Vin
WHERE vehicles.Vin = 10003;
#5
SELECT dealerships.DealershipID, dealerships.Name, dealerships.Address, vehicles.Name AS VehicleName, vehicles.Type
FROM dealerships
JOIN inventory ON inventory.DealershipID = dealerships.DealershipID
JOIN vehicles ON vehicles.Vin = inventory.Vin
WHERE vehicles.Type = 'Sedan';
#6
SELECT dealerships.DealershipID, dealerships.Name, salescontact.CustomerName, salescontact.Vin, salescontact.ContractDate
FROM dealerships  
JOIN salescontact ON salescontact.DealershipID = dealerships.DealershipID
WHERE salescontact.ContractDate BETWEEN '2025-01-01' AND '2025-06-01';