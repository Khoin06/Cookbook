USE master
Go
IF exists (SELECT * FROM sysdatabases WHERE name= 'Cookmanagement2')
DROP DATABASE Cookmanagement2
GO
CREATE DATABASE Cook;
GO

USE Cook;
GO

CREATE TABLE Recipe (
    Recipe_ID NVARCHAR(50) PRIMARY KEY,
    Recipe_TITLE NVARCHAR(MAX),
	Recipe_Steps NVARCHAR(MAX),
	Descriptions_Nutrient NVARCHAR(MAX),
    Descriptions_Time NVARCHAR(MAX),
    Descriptions_Difficult NVARCHAR(MAX),
    Descriptions_Type NVARCHAR(MAX),
    Descriptions_Rate NVARCHAR(MAX),
    Descriptions_Note NVARCHAR(MAX),
	Recipe_Image VARBINARY(MAX),
);
INSERT INTO Recipe (Recipe_ID, Recipe_TITLE, Recipe_Steps, Descriptions_Nutrient, Descriptions_Time, Descriptions_Difficult, Descriptions_Type, Descriptions_Rate, Descriptions_Note, Recipe_Image)
VALUES 
('R001', 'Spaghetti Bolognese', 'Step 1: Cook pasta. Step 2: Prepare sauce. Step 3: Mix together.', 'High in protein', '30 minutes', 'Easy', 'Main Course', '4.5', 'Family favorite', NULL),
('R002', 'Chicken Curry', 'Step 1: Marinate chicken. Step 2: Cook with spices. Step 3: Serve with rice.', 'Rich in spices', '45 minutes', 'Medium', 'Main Course', '4.7', 'Spicy and delicious', NULL),
('R003', 'Vegetable Stir Fry', 'Step 1: Chop vegetables. Step 2: Stir fry with sauce. Step 3: Serve hot.', 'Low in calories', '20 minutes', 'Easy', 'Main Course', '4.2', 'Healthy and quick', NULL);
INSERT INTO Ingredient (Ingredient_ID, Ingredient_NAME)
VALUES 
('I001', 'Tomatoes'),
('I002', 'Chicken Breast'),
('I003', 'Bell Peppers'),
('I004', 'Onions'),
('I005', 'Garlic'),
('I006', 'Olive Oil'),
('I007', 'Salt'),
('I008', 'Pepper'),
('I009', 'Basil'),
('I010', 'Pasta');


CREATE TABLE Ingredient (
    Ingredient_ID NVARCHAR(50) PRIMARY KEY,
    Ingredient_NAME NVARCHAR(100),
);



CREATE TABLE RecipeIngredient (
    Recipe_ID NVARCHAR(50),
    Ingredient_ID NVARCHAR(50),
    Ingredient_QUANTITY int,
	 unit NVARCHAR(255),
	 Recipe_TITLE NVARCHAR(MAX),
	 Ingredient_NAME NVARCHAR(100),
    FOREIGN KEY (Recipe_ID) REFERENCES Recipe (Recipe_ID),
    FOREIGN KEY (Ingredient_ID) REFERENCES Ingredient (Ingredient_ID), 
);



INSERT INTO RecipeIngredient(Recipe_ID,Ingredient_ID,Ingredient_QUANTITY,unit,Recipe_TITLE,Ingredient_NAME) VALUES 

('R003','I002',3,'g','Chicken Curry','Salt'),
('R003','I001',3,'QUẢ','Chicken Curry','Tomatoes');
 
CREATE TABLE ShoppingList (
    ShoppingList_ID INT PRIMARY KEY IDENTITY,
	Ingredient_ID INT,
    Ingredient_NAME NVARCHAR(255),
    Ingredient_QUANTITY FLOAT,
    Recipe_ID INT,
    CONSTRAINT FK_ShoppingList_Recipe FOREIGN KEY (Recipe_ID) REFERENCES Recipe (Recipe_ID),
    CONSTRAINT FK_ShoppingList_Ingredient FOREIGN KEY (Ingredient_ID) REFERENCES Ingredient (Ingredient_ID)
);




CREATE TABLE Menu (
	Menu_ID NVARCHAR(50) PRIMARY KEY,
	Name_ID  NVARCHAR(50),
	Menu_Name NVARCHAR(255),
    Recipe_ID NVARCHAR(50),
	Recipe_TITLE NVARCHAR(50),
	Time_Menu NVARCHAR(50),
    CONSTRAINT FK_Menu_Recipe FOREIGN KEY (Recipe_ID) REFERENCES Recipe (Recipe_ID)
);
 
INSERT INTO Menu (Menu_ID,Name_ID, Menu_Name, Recipe_ID, Recipe_TITLE, Time_Menu) VALUES
('M006', 'N002','aniversary', 'R001', 'Spaghetti Carbonara', 'Dinner'),
('M007', 'N002','aniversary', 'R002', 'Chicken Alfredo', 'Lunch'),
('M008', 'N002','aniversary', 'R003', 'Beef Tacos', 'Dinner'),
('M009','N002', 'aniversary', 'R004', 'Vegetable Stir Fry', 'Lunch'),
('M0010','N002', 'aniversary', 'R004', 'Vegetable Stir Fry', 'Dinner');


('M001', 'N001','Today', 'R001', 'Spaghetti Carbonara', 'Dinner'),
('M002', 'N001','Today', 'R002', 'Chicken Alfredo', 'Lunch'),
('M003', 'N001','Today', 'R003', 'Beef Tacos', 'Dinner'),
('M004','N001', 'Today', 'R004', 'Vegetable Stir Fry', 'Lunch'),
('M005','N001', 'Today', 'R004', 'Vegetable Stir Fry', 'Dinner');

--ALTER TABLE Recipe
--ADD Recipe_Image VARBINARY(MAX);

SELECT Name_ID, COUNT(Recipe_TITLE) AS Total_Recipe_Title
FROM Menu
GROUP BY Name_ID;

SELECT Name_ID, COUNT(Recipe_TITLE) AS Total_Recipe_Title FROM Menu GROUP BY Name_ID


-- Xóa các bản ghi từ bảng Menu có tham chiếu đến recipe có Recipe_ID = 'R001'
DELETE FROM Menu WHERE Recipe_ID = 'R001';
select * from Menu;

-- Xóa các bản ghi từ bảng RecipeIngredient có tham chiếu đến recipe có Recipe_ID = 'R001'
DELETE FROM RecipeIngredient WHERE Recipe_ID = 'R001';

-- Xóa các bản ghi từ bảng ShoppingList có tham chiếu đến recipe có Recipe_ID = 'R001'
DELETE FROM ShoppingList WHERE Recipe_ID = 'R001';

-- Cuối cùng, xóa bản ghi từ bảng Recipe có Recipe_ID = 'R001'
DELETE FROM Recipe WHERE Recipe_ID = 'R001';

SELECT Ingredient_ID, Ingredient_QUANTITY, unit, Ingredient_NAME FROM RecipeIngredient WHERE Recipe_ID ='R003';