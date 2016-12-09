

Create Database Constructora
Go

Use Constructora
Go

Create Login Administrador With Password = '1234'
Go

sp_addsrvrolemember Administrador , sysadmin
Go



Use Constructora
Go

Sp_AddUser Administrador, Administrador
Go



Sp_AddRoleMember [db_owner] , Administrador
Go


Create Table Departamento (
ID_Departamento Int Identity (1,1) Primary Key,
NombreDepartamento Nvarchar (50) not null
)
Go

Create Table Cargo (
ID_Cargo Int Identity (1,1) Primary Key,
NombreCargo Nvarchar (50) not null,
SalarioMin money not null
)
Go

Create Table Trabajador (
ID_Trabajador Int Identity (1,1) Primary Key,
No_Inss Nvarchar (50) not null,
No_Cedula Nvarchar (16) not null,
Nombres_Trabajador Nvarchar (50) not null,
Apellidos_Trabajador Nvarchar (50) not null,
Sexo_Trabajador Nvarchar (10) not null,
Telefono_Trabajador Nvarchar (8) not null,
ID_Cargo Int Foreign Key References Cargo (ID_Cargo) not null,
Salario Money not null,
Anios_Antiguedad int not null,
ID_Departamento Int Foreign Key References Departamento (ID_Departamento) not null,
Estado_Trabajador Nvarchar (10) Default 'Activo' not null,
Check (Sexo_Trabajador in ('Masculino', 'Femenino')),
Check (Estado_Trabajador in ('Activo', 'Inactivo'))
)
Go

Create Table HrsExtras (
ID_HrsExtras Int Identity (1,1) Primary Key,
ID_Trabajador Int Foreign Key References Trabajador (ID_Trabajador) not null,
HrsExtras int not null,
Fecha Date not null,
Estado_Hrs Nvarchar (12) default 'No Cancelado' not null,
Check (Estado_Hrs in ('No Cancelado', 'Cancelado')),
Check (HrsExtras > 0)
)
Go

Create Table Prestamo (
ID_Prestamo Int Identity (1,1) Primary Key,
ID_Trabajador Int Foreign Key References Trabajador (ID_Trabajador) not null,
Prestamo Money not null,
Fecha Date not null,
Estado_Prestamo Nvarchar (12) default 'No Cancelado' not null,
Check (Estado_Prestamo in ('No Cancelado', 'Cancelado')),
Check (Prestamo > 0)
)
Go

Create Table Nomina (
ID_Nomina Int Identity (1,1) Primary Key,
No_Nomina Int not null,
FechaNomina Date not null,
ID_Trabajador Int Foreign Key References Trabajador (ID_Trabajador) not null,
SalarioBasico money not null,
Cantidad_HrsExtras int not null,
Pago_HrsExtras money not null,
AniosAntiguedad int not null,
Antiguedad money not null,
TotalIngresos money not null,
INSS_L money not null,
IR money not null,
TotalDeducciones money not null,
SalarioNeto money not null,
OtrasDeducciones money not null,
SalarioPagar money not null,
INSS_P money not null,
INATEC money not null,
Vacaciones money not null,
TreceavoMes money not null,
Estado_Nomina Nvarchar (12) default 'No Cancelado' not null,
Check (Estado_Nomina in ('No Cancelado', 'Cancelado')),
Check (SalarioBasico > 0),
Check (Cantidad_HrsExtras >= 0),
Check (Pago_HrsExtras >= 0),
Check (Antiguedad >= 0),
Check (TotalIngresos >= 0),
Check (INSS_L >= 0),
Check (IR >= 0),
Check (TotalDeducciones >= 0),
Check (SalarioNeto >= 0),
Check (OtrasDeducciones >= 0),
Check (SalarioPagar >= 0),
Check (INSS_P >= 0),
Check (INATEC >= 0),
Check (Vacaciones >= 0),
Check (TreceavoMes >= 0),


)
Go

Create Table Usuarios(
ID_Usuario Int Identity (1,1) Primary Key,
NombreUsuario Nvarchar(100) not null,
Contrasena Nvarchar (max) not null,
Privilegios Nvarchar (13) default 'Estandar' not null,
Estado_Usuario Nvarchar (10) Default 'Activo' not null,
Check (Privilegios in ('Estandar', 'Administrador')),
Check (Estado_Usuario in ('Activo', 'Inactivo'))
)
Go



Create Procedure Agregar_Departamento(
@NombreDepartamento Nvarchar (50)
)

As
Begin

Begin try


Insert Into [dbo].[Departamento]
           ([NombreDepartamento]
		   )
     Values
           (@NombreDepartamento)


End try

Begin catch
Raiserror('ERROR AL INSERTAR DEPARTAMENTO',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

Create Procedure Modificar_Departamento(
@ID int,
@NombreDepartamento Nvarchar (50)
)

As
Begin

Begin try


Update [dbo].[Departamento]
Set        [NombreDepartamento] = @NombreDepartamento
		   where [ID_Departamento] = @ID




End try

Begin catch
Raiserror('ERROR AL MODIFICAR DEPARTAMENTO',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

Create Procedure Agregar_Cargo(
@NombreCargo Nvarchar (50),
@SalarioMin money
)

As
Begin

Begin try


Insert Into [dbo].[Cargo]
           ([NombreCargo],
			[SalarioMin]
		   )
     Values
           (@NombreCargo, @SalarioMin)


End try

Begin catch
Raiserror('ERROR AL INSERTAR CARGO',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

Create Procedure Modificar_Cargo(
@ID int,
@NombreCargo Nvarchar (50),
@SalarioMin money
)

As
Begin

Begin try


Update [dbo].[Cargo]
Set        [NombreCargo]= @NombreCargo,
		   [SalarioMin] = @SalarioMin
		   where [ID_Cargo]  = @ID




End try

Begin catch
Raiserror('ERROR AL MODIFICAR CARGO',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------


Create Procedure Agregar_Trabajador(
@No_Inss Nvarchar(50),
@NoCedula Nvarchar(16),
@Nombres Nvarchar(50),
@Apellidos Nvarchar(50),
@Sexo Nvarchar(10),
@Telefono Nvarchar(8),
@ID_Cargo int,
@Salario money,
@Anios_Antiguedad int,
@ID_Departamento int
)

As
Begin

Begin try


Insert Into [dbo].[Trabajador]
           ([No_Inss],
		   [No_Cedula],
		   [Nombres_Trabajador],
		   [Apellidos_Trabajador],
		   [Sexo_Trabajador],
		   [Telefono_Trabajador],
		   [ID_Cargo],
		   [Salario],
		   [Anios_Antiguedad],
		   [ID_Departamento]
		   )
     Values
           (@No_Inss, @NoCedula, @Nombres, @Apellidos, @Sexo, @Telefono, @ID_Cargo, @Salario,
		   @Anios_Antiguedad, @ID_Departamento)


End try

Begin catch
Raiserror('ERROR AL INSERTAR TRABAJADOR',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

Create Procedure Modificar_Trabajador(
@ID int,
@No_Inss Nvarchar(50),
@NoCedula Nvarchar(16),
@Nombres Nvarchar(50),
@Apellidos Nvarchar(50),
@Sexo Nvarchar(10),
@Telefono Nvarchar(8),
@ID_Cargo int,
@Salario money,
@Anios_Antiguedad int,
@ID_Departamento int
)

As
Begin

Begin try


Update [dbo].[Trabajador]
Set        [No_Inss] = @No_Inss,
		   [No_Cedula] = @NoCedula,
		   [Nombres_Trabajador] = @Nombres,
		   [Apellidos_Trabajador] = @Apellidos,
		   [Sexo_Trabajador] = @Sexo,
		   [Telefono_Trabajador] = @Telefono,
		   [ID_Cargo] = @ID_Cargo,
		   [Salario] = @Salario,
		   [Anios_Antiguedad] = @Anios_Antiguedad,
		   [ID_Departamento] = @ID_Departamento
		   where [ID_Trabajador]  = @ID




End try

Begin catch
Raiserror('ERROR AL MODIFICAR TRABAJADOR',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

Create Procedure Activar_Trabajador(
@ID int
)

As
Begin

Begin try


Update [dbo].[Trabajador]
Set        [Estado_Trabajador] = 'Activo'
		   where [ID_Trabajador]  = @ID




End try

Begin catch
Raiserror('ERROR AL ACTIVAR TRABAJADOR',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------


Create Procedure Desactivar_Trabajador(
@ID int
)

As
Begin

Begin try


Update [dbo].[Trabajador]
Set        [Estado_Trabajador] = 'Inactivo'
		   where [ID_Trabajador]  = @ID




End try

Begin catch
Raiserror('ERROR AL ACTIVAR TRABAJADOR',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------


Create Procedure Agregar_HrsExtras(
@ID_Trabajador int,
@HrsExtras int,
@Dia int,
@Mes int,
@Anio int
)

As
Begin

Begin try

Declare @Fecha date

Set @Fecha = DATEFROMPARTS (@Anio, @Mes, @Dia)

Insert Into [dbo].[HrsExtras]
           ([ID_Trabajador],
		   [HrsExtras],
		   [Fecha]
		   )
     Values
           (@ID_Trabajador, @HrsExtras, @Fecha)


End try

Begin catch
Raiserror('ERROR AL INSERTAR HORAS EXTRAS',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

Create Procedure Modificar_HrsExtras(
@ID int,
@ID_Trabajador int,
@HrsExtras int,
@Dia int,
@Mes int,
@Anio int
)

As
Begin

Begin try

Declare @Fecha date

Set @Fecha = DATEFROMPARTS (@Anio, @Mes, @Dia)


Update [dbo].[HrsExtras]
Set        [ID_Trabajador] = @ID_Trabajador,
		   [HrsExtras] = @HrsExtras,
		   [Fecha] = @Fecha
		   where [ID_HrsExtras]  = @ID




End try

Begin catch
Raiserror('ERROR AL MODIFICAR HORAS EXTRAS',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

Create Procedure Pagar_HrsExtras
(@ID int
)
As
Begin

Begin try


Update [dbo].[HrsExtras]
Set      [Estado_Hrs] = 'Cancelado'
		   where  [ID_Trabajador] = @ID




End try

Begin catch
Raiserror('ERROR AL CANCELAR HORAS EXTRAS',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

Create Procedure Agregar_Prestamo(
@ID_Trabajador int,
@Prestamo int,
@Dia int,
@Mes int,
@Anio int
)

As
Begin

Begin try

Declare @Fecha date

Set @Fecha = DATEFROMPARTS (@Anio, @Mes, @Dia)

Insert Into [dbo].[Prestamo]
           ([ID_Trabajador],
		    [Prestamo],
		    [Fecha]
		   )
     Values
           (@ID_Trabajador, @Prestamo, @Fecha)


End try

Begin catch
Raiserror('ERROR AL INSERTAR PRESTAMO',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

Create Procedure Modificar_Prestamo(
@ID int,
@ID_Trabajador int,
@Prestamo int,
@Dia int,
@Mes int,
@Anio int
)

As
Begin

Begin try

Declare @Fecha date

Set @Fecha = DATEFROMPARTS (@Anio, @Mes, @Dia)


Update [dbo].[Prestamo]
Set        [ID_Trabajador] = @ID_Trabajador,
		   [Prestamo] = @Prestamo,
		   [Fecha] = @Fecha
		   where [ID_Prestamo]  = @ID




End try

Begin catch
Raiserror('ERROR AL MODIFICAR PRESTAMO',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

Create Procedure Pagar_Prestamo
(
@ID int
)
As
Begin

Begin try


Update   [dbo].[Prestamo]
Set      [Estado_Prestamo] = 'Cancelado'
		   where [ID_Trabajador] = @ID




End try

Begin catch
Raiserror('ERROR AL CANCELAR PRESTAMO',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------


Create Procedure Agregar_Nomina(
@No_Nomina int,
@Dia int,
@Mes int,
@Anio int,
@ID_Trabajador int,
@SalarioBasico money,
@Cantidad_HrsExtras int,
@Pago_HrsExtras money,
@AnioAntiguedad int,
@Antiguedad money,
@TotalIngresos money,
@INSS_L money,
@IR money,
@TotalDeducciones money,
@SalarioNeto money,
@OtrasDeducciones money,
@SalarioPagar money,
@INSS_P money,
@INATEC money,
@Vacaciones money,
@TreceavoMes money
)

As
Begin

Begin try

Declare @Fecha date

Set @Fecha = DATEFROMPARTS (@Anio, @Mes, @Dia)

Insert Into [dbo].[Nomina]
           ([No_Nomina],
		   [FechaNomina],
		   [ID_Trabajador],
		   [SalarioBasico],
		   [Cantidad_HrsExtras],
		   [Pago_HrsExtras],
		   [AniosAntiguedad],
		   [Antiguedad],
		   [TotalIngresos],
		   [INSS_L],
		   [IR],
		   [TotalDeducciones],
		   [SalarioNeto],
		   [OtrasDeducciones],
		   [SalarioPagar],
		   [INSS_P],
		   [INATEC],
		   [Vacaciones],
		   [TreceavoMes])
     Values
           (@No_Nomina, @Fecha, @ID_Trabajador, @SalarioBasico, @Cantidad_HrsExtras, @Pago_HrsExtras, @AnioAntiguedad, @Antiguedad,
		   @TotalIngresos, @INSS_L, @IR, @TotalDeducciones, @SalarioNeto, @OtrasDeducciones, @SalarioPagar, @INSS_P, @INATEC, @Vacaciones,
		   @TreceavoMes)


End try

Begin catch
Raiserror('ERROR AL INSERTAR NOMINA',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

Create Procedure Pagar_Nomina
(
@ID int
)
As
Begin

Begin try


Update   [dbo].[Nomina]
Set      [Estado_Nomina] = 'Cancelado'
		   where [No_Nomina] = @ID




End try

Begin catch
Raiserror('ERROR AL CANCELAR NOMINA',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------


Create view TrabajadorV
as
(
Select T.ID_Trabajador, T.No_Inss, T.Nombres_Trabajador, T.Apellidos_Trabajador, T.No_Cedula, T.Sexo_Trabajador, T.Telefono_Trabajador,
D.NombreDepartamento,C.NombreCargo ,T.Salario ,T.Anios_Antiguedad, T.Estado_Trabajador
from  [dbo].[Trabajador] T
Inner Join [dbo].[Departamento] D
On T.ID_Departamento = D.ID_Departamento
Inner Join [dbo].[Cargo] C
On T.ID_Cargo = C.ID_Cargo

)
Go

Create View HorasExtrasV
as
(
Select H.ID_HrsExtras, T.Nombres_Trabajador, T.Apellidos_Trabajador, H.HrsExtras, H.Fecha, H.Estado_Hrs
from [dbo].[HrsExtras] H
Inner Join [dbo].[Trabajador] T
On H.ID_Trabajador = T.ID_Trabajador
)
Go

Create View PrestamoV
as
(
Select P.ID_Prestamo, T.Nombres_Trabajador, T.Apellidos_Trabajador, P.Prestamo, P.Fecha, P.Estado_Prestamo
from [dbo].[Prestamo] P
Inner Join [dbo].[Trabajador] T
On P.ID_Trabajador = T.ID_Trabajador
)
Go


Create View NominaV
as
(Select N.ID_Nomina, N.No_Nomina, N.FechaNomina, T.Nombres_Trabajador, T.Apellidos_Trabajador, T.No_Inss, T.NombreDepartamento,
T.NombreCargo, N.SalarioBasico, N.Cantidad_HrsExtras, N.Pago_HrsExtras, N.AniosAntiguedad, N.Antiguedad, N.TotalIngresos, N.INSS_L,
N.IR, N.TotalDeducciones, N.SalarioNeto, N.OtrasDeducciones, N.SalarioPagar, N.INSS_P, N.INATEC, N.Vacaciones, N.TreceavoMes, N.Estado_Nomina
from [dbo].[Nomina] N
Inner Join [dbo].[TrabajadorV] T
On N.ID_Trabajador = T.ID_Trabajador
)
