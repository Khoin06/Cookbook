USE master
Go
IF exists (SELECT * FROM sysdatabases WHERE name= 'Cookbook')
DROP DATABASE Cookbook
GO
CREATE DATABASE Cookbook;
GO

USE Cookbook;
GO

CREATE TABLE Ingredient (
    Ingredient_ID INT CONSTRAINT PK_Ingredient PRIMARY KEY,
    Ingredient_NAME NVARCHAR(255)
);

CREATE TABLE Recipe (
    Recipe_ID INT CONSTRAINT PK_Recipe PRIMARY KEY,
    Recipe_TITLE NVARCHAR(255),
    Ingredient_ID INT,
	Recipe_Steps NVARCHAR(MAX),
    Descriptions_ID INT,
	Descriptions_NUTRIENT NVARCHAR(MAX),
    Descriptions_TIME TIME,
    Descriptions_DIFFICULT INT,
    Descriptions_TYPE NVARCHAR(255),
    Descriptions_RATE INT,
    Descriptions_NOTE NVARCHAR(MAX),
    CONSTRAINT FK_Recipe_Ingredient FOREIGN KEY (Ingredient_ID) REFERENCES Ingredient (Ingredient_ID),
  
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

