CREATE TABLE dealerships(
DealershipID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(50) NOT NULL,
Address VARCHAR(50) NOT NULL,
Phone VARCHAR(12)
);

CREATE TABLE vehicles(
Vin INT PRIMARY KEY NOT NULL, 
Name VARCHAR(50) NOT NULL,
Type VARCHAR(15) NOT NULL,
Sold bit NOT NULL
);

CREATE TABLE inventory(
DealershipID int,
Vin int,
foreign key (DealershipID) references dealerships(DealershipID),
foreign key (Vin) references vehicles(Vin)
);

CREATE TABLE salescontact(
ContractID INT AUTO_INCREMENT PRIMARY KEY,
    Vin int ,
    CustomerName VARCHAR(50),
    SalePrice DECIMAL(10,2),
    ContractDate DATE,
    DealershipID INT,
     FOREIGN KEY (Vin) REFERENCES vehicles(Vin),
    FOREIGN KEY (DealershipID) REFERENCES dealerships(DealershipID)
);

CREATE TABLE leasecontracts (
    LeaseID INT AUTO_INCREMENT PRIMARY KEY,
    Vin int,
    CustomerName VARCHAR(50),
    LeaseTermMonths INT,
    MonthlyPayment DECIMAL(10,2),
    ContractDate DATE,
    DealershipID INT,
    FOREIGN KEY (Vin) REFERENCES vehicles(Vin),
    FOREIGN KEY (DealershipID) REFERENCES dealerships(DealershipID)
);

INSERT INTO dealerships (Name, Address, Phone) VALUES
('Sunrise Autos', '123 Main St, Phoenix', '6025551234'),
('Elite Motors', '456 Grand Ave, Tucson', '5205556789'),
('Premier Cars', '789 Oak Blvd, Mesa', '4805559012');

INSERT INTO vehicles (Vin, Name, Type, Sold) VALUES
(10001, 'Toyota Camry', 'Sedan', 1),
(10002, 'Honda Accord', 'Sedan', 0),
(10003, 'Ford F-150', 'Truck', 1),
(10004, 'Chevy Malibu', 'Sedan', 0),
(10005, 'Tesla Model 3', 'Electric', 1);

INSERT INTO inventory (DealershipID, Vin) VALUES
(1, 10001),
(1, 10002),
(2, 10003),
(3, 10004),
(3, 10005);

INSERT INTO salescontact (Vin, CustomerName, SalePrice, ContractDate, DealershipID) VALUES
('10001', 'Alex Johnson', 23500.00, '2024-10-12', 1),
('10003', 'Maria Lopez', 41500.00, '2025-02-03', 2),
('10005', 'Jordan Smith', 48999.99, '2025-05-28', 3);

INSERT INTO leasecontracts (Vin, CustomerName, LeaseTermMonths, MonthlyPayment, ContractDate, DealershipID) VALUES
('10002', 'Nina Patel', 36, 299.99, '2025-04-15', 1),
('10004', 'Leo Tran', 24, 349.50, '2025-03-22', 3);



