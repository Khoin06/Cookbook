USE master
Go
IF exists (SELECT * FROM sysdatabases WHERE name= 'Cookmanagement2')
DROP DATABASE Cookmanagement2
GO
CREATE DATABASE Cookmanagement2;
GO

USE Cookmanagement2;
GO

CREATE TABLE Recipe (
    Recipe_ID NVARCHAR(255) PRIMARY KEY,
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

CREATE TABLE Ingredient (
    Ingredient_ID INT PRIMARY KEY,
    Ingredient_NAME NVARCHAR(MAX),
);



CREATE TABLE RecipeIngredient (
    Recipe_ID INT,
    Ingredient_ID INT,
    Ingredient_QUANTITY FLOAT,
    FOREIGN KEY (Recipe_ID) REFERENCES Recipe (Recipe_ID),
    FOREIGN KEY (Ingredient_ID) REFERENCES Ingredient (Ingredient_ID),
   
);

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
    Recipe_ID INT,
    CONSTRAINT FK_Menu_Recipe FOREIGN KEY (Recipe_ID) REFERENCES Recipe (Recipe_ID)
);
--ALTER TABLE Recipe
--ADD Recipe_Image VARBINARY(MAX);

