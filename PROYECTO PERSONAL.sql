
create table Area_Laboral(
Id_AreaLaboral int not null primary key identity(1,1),
Area_Laboral varchar(40)
);

insert into Area_Laboral values('Soporte Tecnico'),('Administracion'),('Mantenimiento');

create table Usuario(
Id_Usuario int not null primary key identity(1,1),
Estado int not null references Estado_Usuario(Id_EstadoUsuario),
Profesion int not null references Profesion(Id_Profesion),
Cargo int not null references Cargo_Laboral(Id_Cargo),
Area int not null references Area_Laboral(Id_AreaLaboral),
Usuario varchar(40),
Clave varchar(75),
DUI char(10),
Telefono char(9),
Correo_Electronico varchar(75),
Fecha_Contratacion DATE,
);

create view Vista_Usuarios
as
select Id_Usuario,e.Estado_Usuario,p.Profesion,c.Cargo,a.Area_Laboral,Usuario,Clave,DUI,Telefono,Correo_Electronico,Fecha_Contratacion
from Usuario u,Estado_Usuario e,Profesion p,Cargo_Laboral c,Area_Laboral a
where u.Area = a.Id_AreaLaboral and e.Id_EstadoUsuario = u.Estado and u.Profesion = p.Id_Profesion and c.Id_Cargo = u.Cargo

create table Tipo_Empresa(
Id_TipoEmpresa int not null primary key identity(1,1),
Tipo_Empresa varchar(30)
);

insert into Tipo_Empresa values('Casa Matriz');

create table Empresa(
Id_Empresa int not null primary key identity(1,1),
Tipo int not null references Tipo_Empresa(Id_TipoEmpresa),
Nombre_Empresa VARCHAR(40) not null,
Ubicaci�n_Empresa VARCHAR(75),
Telefono char(9),
Correo_Empresa VARCHAR(60),
Telefono2 char(9),
);

create view Vista_Empresa
as
select Id_Empresa,t.Tipo_Empresa,Nombre_Empresa,Ubicaci�n_Empresa,Telefono,Correo_Empresa,Telefono2
from Empresa,Tipo_Empresa t
where Empresa.Tipo = t.Id_TipoEmpresa

create table Estado_Personal(
Id_EstadoPersonal int not null primary key identity(1,1),
Estado_Personal varchar(25)
);

insert into Estado_Personal values('Ocupado'),('Disponible'),('Ausente'),('Inactivo')

create table Personal(
Id_Personal int not null primary key identity(1,1),
Nombre varchar(50),
Apellido varchar(50),
Telefono char(9),
DUI char(10),
Profesion int not null references Profesion(Id_Profesion),
Cargo int not null references Cargo_Laboral(Id_Cargo),
Estado int not null references Estado_Personal(Id_EstadoPersonal),
Area int not null references Area_Laboral(Id_AreaLaboral),
Sueldo numeric(8,2) not null,
Empresa int not null references Empresa(Id_Empresa)
);

create view Vista_Personal
as
select Id_Personal,p.Profesion,e.Estado_Personal as Estado,c.Cargo,Nombre,Apellido,pe.Telefono,DUI,a.Area_Laboral,pe.Sueldo,em.Nombre_Empresa
from Personal pe,Profesion p,Estado_Personal e,Cargo_Laboral c,Area_Laboral a,Empresa em
where pe.Profesion = p.Id_Profesion and pe.Estado = e.Id_EstadoPersonal and pe.Cargo = c.Id_Cargo
and a.Id_AreaLaboral = pe.Area and em.Id_Empresa = pe.Empresa

create table Cliente(
Id_Cliente int not null primary key identity(1,1),
Empresa int not null references Empresa(Id_Empresa),
Nombre varchar(40),
Apellido varchar(40),
Telefono char(9),
DUI char(10),
Correo_Electronico varchar(50),
);

create view Vista_Cliente
as
select Id_Cliente,e.Nombre_Empresa,Nombre,Apellido,c.Telefono,DUI,Correo_Electronico
from Cliente c,Empresa e 
where c.Empresa = e.Id_Empresa

create table Asignaciones(
Id_Asignacion int not null primary key identity(1,1),
Asignacion varchar(40)
);

insert into Asignaciones values('Logistica');

create table Estado_Asignacion(
Id_EstadoAsignacion int not null primary key identity(1,1),
Estado_Asignacion varchar(35)
);

insert into Estado_Asignacion values('En proceso'),('Finalizado');

CREATE TABLE Tipo_Proyecto(
Id_tipoProyecto int not null primary key identity(1,1),
Tipo_Proyecto varchar(30)
);

insert into Tipo_Proyecto values('Obra civil'),('Remodelacion'),('Demolicion')

CREATE TABLE Estado_Proyecto(
Id_estadoProyecto int not null primary key identity(1,1),
Estado_Proyecto varchar(30)
);

insert into Estado_Proyecto values('Definido'),('En proceso'),('Finalizado')

create table Proyecto(
Id_Proyecto int not null primary key identity(1,1),
Estado int not null REFERENCES Estado_Proyecto(Id_estadoProyecto),
Seguro int not null REFERENCES Seguro(Id_Seguro),
Cliente int not null REFERENCES Cliente(Id_cliente),
Supervisor int not null REFERENCES Usuario(Id_Usuario),
Tipo_Proyecto int not null REFERENCES Tipo_Proyecto(Id_tipoProyecto),
Nombre_Proyecto varchar(40),
Ubicaci�n varchar(100),
Descripcion_Proyecto varchar(150),
FechaInicio date,
FechaFin date,
);

create view Vista_Proyecto
as
select Id_Proyecto,e.Estado_Proyecto,s.Seguro,c.Nombre,c.Apellido,u.Usuario,t.Tipo_Proyecto,Nombre_Proyecto,Ubicaci�n,Descripcion_Proyecto,FechaInicio,FechaFin 
from Proyecto p,Seguro s,Estado_Proyecto e,Cliente c,Usuario u,Tipo_Proyecto t
where p.Estado = e.Id_estadoProyecto and s.Id_Seguro = p.Seguro and c.Id_Cliente = p.Cliente and t.Id_tipoProyecto = p.Tipo_Proyecto and p.Supervisor = u.Id_Usuario

create table Fotografias(
Id_Fotografia int not null primary key identity(1,1),
Proyecto int not null references Proyecto(Id_Proyecto),
Fotografia image,
);

create table Asignaciones_Proyecto(
Id_Asignaciones int not null primary key identity(1,1),
Proyecto int not null REFERENCES Proyecto(Id_Proyecto),
Asignacion int not null references Asignaciones(Id_Asignacion),
Estado_Asignacion int not null references Estado_Asignacion(Id_EstadoAsignacion),
Encargado int not null references Personal(Id_Personal),
Fecha_Incio date,
Fecha_Fin date,
SueldoTotal numeric(8,2)
);

create view Vista_Asignaciones
as
select Id_Asignaciones,Nombre_Proyecto,asi.Asignacion,e.Estado_Asignacion,pe.Nombre,pe.Apellido,Fecha_Incio,Fecha_Fin,pe.Sueldo,a.SueldoTotal,pe.DUI
from Asignaciones_Proyecto a,Proyecto p,Personal pe,Asignaciones asi,Estado_Asignacion e
where a.Encargado = pe.Id_Personal and a.Asignacion = asi.Id_Asignacion and a.Estado_Asignacion = e.Id_EstadoAsignacion 
and a.Proyecto = p.Id_Proyecto

create view Vista_Actividades
as
select Id_Asignaciones,p.Nombre_Proyecto,a.Asignacion,ea.Estado_Asignacion,concat(pe.Nombre,' ',pe.Apellido) as Encargado,Fecha_Incio,Fecha_Fin,pe.DUI
from Asignaciones_Proyecto ap,Asignaciones a,Proyecto p,Estado_Asignacion ea,Personal pe
where ap.Asignacion = a.Id_Asignacion and ap.Proyecto = p.Id_Proyecto and ap.Encargado = pe.Id_Personal and ap.Estado_Asignacion = ea.Id_EstadoAsignacion

select * from Asignaciones_Proyecto  update Personal set Estado = 1

select * from Asignaciones_Proyecto

select * from Vista_Materiales

select * from Vista_Actividades where Encargado like '%D%' and Nombre_Proyecto = 'Construccion Ricaldone'

update Estado_Asignacion set Estado_Asignacion = 'No realizada' where Id_EstadoAsignacion = 1

select * from Vista_Actividades where Nombre_Proyecto = 'Construccion Ricaldone'

CREATE TABLE Estado_Materiales(
Id_EstadoMateriales int not null primary key,
Estado_Material varchar(30)
);

insert into Estado_Materiales values (1,'Disponible'),(2,'Agotado')

create table Unidad_Medida(
Id_UnidadMedida int not null primary key identity(1,1),
Unidad_Medida varchar(20)
);

insert into Unidad_Medida values('Quintal')

CREATE TABLE Materiales(
Id_Material int not null primary key identity(1,1),
Unidad int not null REFERENCES Unidad_Medida(Id_UnidadMedida),
Nombre_Material varchar(30),
Descripcion varchar(40),
Foto_Material image,
);

create view Vista_Materiales
as
select m.Id_Material,m.Nombre_Material,m.Unidad,m.Descripcion,m.Foto_Material 
from Materiales m,Unidad_Medida u
where m.Unidad = u.Id_UnidadMedida

CREATE TABLE Compras_Materiales(
Id_Compra int not null primary key identity(1,1),
Material int not null references Materiales(Id_Material),
Encargado int not null references Usuario(Id_Usuario),
Cantidad_Comprada int,
Monto_Total numeric(7,2),
Fecha_Compra datetime
);

create view Vista_CompraMaterial
as
select cm.Id_Compra,m.Nombre_Material,u.Usuario,e.Nombre_Empresa as Proveedor,cm.Cantidad_Comprada,cm.Precio_Unitario,Monto_Total,Cantidad_Disponible,em.Estado_Material,Uni.Unidad_Medida,Fecha_Compra
from Compras_Materiales cm ,Materiales m,Usuario u,Unidad_Medida uni,Empresa e,Estado_Materiales em
where m.Unidad = uni.Id_UnidadMedida and cm.Material = m.Id_Material and cm.Encargado = u.Id_Usuario and cm.Proveedor = e.Id_Empresa and em.Id_EstadoMateriales = m.Estado


CREATE TABLE Presupuesto_Proyecto(
Id_Presupuesto int not null primary key identity(1,1),
Proyecto int not null REFERENCES Proyecto(Id_Proyecto) UNIQUE,
Gastos_Preliminares numeric(10,2) null,
Instalaciones numeric(10,2) null,
Mano_Obra numeric(10,2) null, 
Precio_Materiales numeric(10,2) null,
SubTotal numeric(10,2) null,
Impuestos numeric(10,2) null,
Monto_Total numeric(12,2) null,
Fecha_Modificacion datetime null,
);

create trigger crearPresupuesto
on Proyecto
after insert 
as 
begin 
declare @precio int
set @precio = 0
declare @proyecto int
set @proyecto = (select max(Id_Proyecto) from Proyecto)
declare @hora datetime
set @hora = (getDate())
insert into Presupuesto_Proyecto values(@proyecto,@precio,@precio,@precio,@precio,@precio,@precio,@precio,@hora)
end

CREATE TABLE Gastos_Inicial(
Id_GastoInicial int not null primary key identity(1,1),
Gasto_Inicial varchar(40) not null,
Precio_Unitario numeric(8,2),
Descripcion varchar(60),
Foto image
);

insert into Gastos_Inicial values('Alquiler de Maquinaria',550.00,'Alquiler de excavadora modelo #####',null);

CREATE TABLE Gastos_Preliminares(
Id_GastoPreliminar int not null primary key identity(1,1),
Presupuesto int not null references Presupuesto_Proyecto(Id_Presupuesto),
Gasto int not null references Gastos_Inicial(Id_GastoInicial),
Cantidad numeric(6) not null,
Precio_Total numeric(9,2) not null,
Fecha_Modificacion datetime,
);

select * from Gastos_Preliminares

create view Vista_GastosPreliminares
as
select Id_GastoPreliminar,gi.Gasto_Inicial,Cantidad,Precio_Unitario,Precio_Total,Presupuesto
from Gastos_Preliminares gp,Gastos_Inicial gi
where gp.Gasto = gi.Id_GastoInicial

CREATE TABLE Gastos_Instalaciones(
Id_GastoInstalaciones int not null primary key identity(1,1),
Presupuesto int not null references Presupuesto_Proyecto(Id_Presupuesto),
Instalacion varchar(50),
Cantidad numeric(3),
Descripcion varchar(150),
Precio_Total numeric(9,2),
Precio_Unitario numeric(8,2),
Fecha_Modificacion datetime not null default getDate(),
);

delete from Gastos_Instalaciones
select * from Gastos_Instalaciones where Presupuesto

create function obtenerFecha()
returns datetime
as
begin
declare @fecha datetime
set @fecha = (select getDate())
return @fecha
end

select dbo.obtenerFecha()

CREATE TABLE Gastos_Materiales(
Id_GastoMateriales int not null primary key identity(1,1),
Presupuesto int not null references Presupuesto_Proyecto(Id_Presupuesto),
Material int not null references Materiales(Id_Material),
Cantidad numeric(6),
Precio_Total numeric(9,2),
Fecha_Modificacion datetime,
);

/*create view Vista_GastoMateriales 
as
select Id_GastoMateriales,m.Nombre_Material,gm.Cantidad,m.Precio_Unitario,gm.Precio_Total,u.Unidad_Medida,m.Cantidad as Cantidad_Bodega,Presupuesto
from Gastos_Materiales gm,Materiales m,Unidad_Medida u 
where gm.Material = m.Id_Material and m.Unidad = u.Id_UnidadMedida*/

create procedure actualizarMateriales
@cantidad int,
@idMaterial int
as
	declare @estado int
	declare @cantidadBodega int
begin
	set @cantidadBodega =(select Cantidad from Materiales where Id_Material = @idMaterial) 
	set @cantidad = @cantidadBodega-@cantidad
	set @estado = 1
if(@cantidad = 0)
BEGIN
	set @estado = 2
END
	update Materiales set Cantidad = @cantidad , Estado = @estado where Id_Material = @idMaterial
end

exec actualizarMateriales 20,1

select * from Materiales

create procedure actualizarGastoPreliminares
@presupuesto int
as
begin 
declare @gasto numeric(8,2)
set @gasto = (select sum(Precio_Total) from Gastos_Preliminares where Presupuesto = @presupuesto)
IF (@gasto is null) 
BEGIN 
set @gasto = 0
END 
update Presupuesto_Proyecto set Gastos_Preliminares = @gasto 
where Id_Presupuesto = @presupuesto
end 

create procedure actualizarGastoInstalaciones
@presupuesto int
as
begin 
declare @gasto numeric(8,2)
set @gasto = (select sum(Precio_Total) from Gastos_Instalaciones where Presupuesto = @presupuesto)
IF (@gasto is null) 
BEGIN 
set @gasto = 0
END 
update Presupuesto_Proyecto set Instalaciones = @gasto 
where Id_Presupuesto = @presupuesto
end 

create procedure actualizarManoObra
@presupuesto int,
@proyecto int
as
begin 
declare @gasto numeric(8,2)
set @gasto = (select sum(SueldoTotal) from Asignaciones_Proyecto where Proyecto = @proyecto)
IF (@gasto is null) 
BEGIN 
set @gasto = 0
END 
update Presupuesto_Proyecto set Mano_Obra = @gasto 
where Id_Presupuesto = @presupuesto
end 

create procedure actualizarGastoMaterial
@presupuesto int
as
begin 
declare @gasto numeric(8,2)
set @gasto = (select sum(Precio_Total) from Gastos_Materiales where Presupuesto = @presupuesto)
IF (@gasto is null) 
BEGIN 
set @gasto = 0
END 
update Presupuesto_Proyecto set Precio_Materiales = @gasto 
where Id_Presupuesto = @presupuesto
end 

create procedure actualizarTotales
@presupuesto int
as
begin 
declare @subTotal numeric(8,2)
declare @impuesto numeric(8,2)
declare @total numeric (10,2)
set @subTotal = (select SUM(Instalaciones+Gastos_Preliminares+Mano_Obra+Precio_Materiales) from Presupuesto_Proyecto where Id_Presupuesto = @presupuesto )
set @impuesto = (@subTotal*13)/100
set @total = @subTotal + @impuesto
update Presupuesto_Proyecto set SubTotal = @subTotal , Impuestos = @impuesto , Monto_Total = @total, Fecha_Modificacion = GETDATE()
where Id_Presupuesto = @presupuesto
end 

select * from Presupuesto_Proyecto
exec actualizarTotales 1
