/* BASE DE DATOS POSTGRESQL PARA PROYECTO PROBUILDER
*  Ultima actualizacion 11/12/2022
*  Vistas, Triggers y funciones incluidas
*/
create table Profesion(
Id_Profesion serial not null primary key,
Profesion varchar(40) not null
);

insert into Profesion values(default,'Mecanico'),(default,'Electricista');

create table Tipo_Usuario(
Id_Tipo serial not null primary key,
Tipo_Usuario varchar(40) not null
);

insert into Tipo_Usuario values(default,'Root'),(default,'Administrador');

create table Tipo_Empresa(
Id_TipoEmpresa serial not null primary key,
Tipo_Empresa varchar(30) not null
);

insert into Tipo_Empresa values(default,'Casa Matriz');

create table Empresa(
Id_Empresa serial not null primary key,
Tipo int not null references Tipo_Empresa(Id_TipoEmpresa),
Nombre VARCHAR(40) not null,
Ubicacion VARCHAR(75) not null,
Telefono char(9) not null,
Correo VARCHAR(60) not null,
Telefono2 char(9) null,
Logo bytea null
);

create view Vista_Empresa
as
select Id_Empresa,t.Tipo_Empresa,Nombre,Ubicacion,Telefono,Correo,Telefono2,Logo
from Empresa,Tipo_Empresa t
where Empresa.Tipo = t.Id_TipoEmpresa

create table Personal(
Id_Personal serial not null primary key,
Nombre varchar(50) not null,
Apellido varchar(50) not null,
Telefono char(9) not null unique,
DUI char(10) not null unique,
Profesion int not null references Profesion(Id_Profesion),
Estado boolean not null default true,
Sueldo numeric(8,2) not null default 0
);

insert into Personal values (default,'Diego','Castro','9787-1365','01234567-8',1,default,default);

create view Vista_Personal
as
select Id_Personal,p.Profesion,Estado as Estado,pe.Nombre,Apellido,pe.Telefono,DUI,pe.Sueldo
from Personal pe,Profesion p
where pe.Profesion = p.Id_Profesion 

create table Usuario(
Id_Usuario serial not null primary key,
Tipo int not null references Tipo_Usuario(Id_Tipo),
Trabajador int not null references Personal(Id_Personal),
Estado boolean not null default true,
Usuario varchar(40) not null unique,
Clave varchar(75) not null default '9b280cdab8a415d8ab17414be48e9aa7',
Correo_Electronico varchar(75) not null
);

insert into Usuario values (default,1,1,true,'eb1eb9061e9f4cf31d3e0d5670a8704a','Diego@gmail.com');

create view Vista_Usuario
as
select Id_Usuario,u.Estado,Usuario,Clave,Correo_Electronico,p.Nombre,p.Apellido,p.DUI,t.Tipo_Usuario
from Usuario u,Personal p,Tipo_Usuario t
where u.Trabajador = p.Id_Personal and t.Id_Tipo = u.Tipo

create table Cliente(
Id_Cliente serial not null primary key,
Empresa int not null references Empresa(Id_Empresa),
Nombre varchar(40) not null,
Apellido varchar(40) not null,
Telefono char(9) not null,
DUI char(10) not null,
Correo_Electronico varchar(50) null
);

create view Vista_Cliente
as
select Id_Cliente,e.Nombre as empresa,c.Nombre,Apellido,c.Telefono,DUI,Correo_Electronico
from Cliente c,Empresa e 
where c.Empresa = e.Id_Empresa

create table Asignaciones(
Id_Asignacion serial not null primary key,
Asignacion varchar(40) not null
);

insert into Asignaciones values(default,'Logistica');

CREATE TABLE Tipo_Proyecto(
Id_tipoProyecto serial not null primary key,
Tipo_Proyecto varchar(30) not null
);

insert into Tipo_Proyecto values(default,'Obra civil'),(default,'Remodelacion'),(default,'Demolicion');

create table Proyecto(
Id_Proyecto serial not null primary key,
Estado boolean not null default false,
Cliente int not null REFERENCES Cliente(Id_cliente),
Supervisor int not null REFERENCES Usuario(Id_Usuario),
Tipo_Proyecto int not null REFERENCES Tipo_Proyecto(Id_tipoProyecto),
Nombre_Proyecto varchar(40) not null,
Ubicacion varchar(100) null,
Descripcion_Proyecto varchar(150) null,
FechaInicio date not null default current_date,
FechaFin date not null
); 

create view Vista_Proyecto
as
select Id_Proyecto,p.Estado,c.Nombre,c.Apellido,u.Usuario,t.Tipo_Proyecto,Nombre_Proyecto,Ubicacion,Descripcion_Proyecto,FechaInicio,FechaFin 
from Proyecto p,Cliente c,Usuario u,Tipo_Proyecto t
where c.Id_Cliente = p.Cliente and t.Id_tipoProyecto = p.Tipo_Proyecto and p.Supervisor = u.Id_Usuario

create table Fotografias(
Id_Fotografia serial not null primary key,
Proyecto int not null references Proyecto(Id_Proyecto),
Fotografia bytea null
);

create table Asignaciones_Proyecto(
Id_Asignaciones serial not null primary key,
Proyecto int not null REFERENCES Proyecto(Id_Proyecto),
Asignacion int not null references Asignaciones(Id_Asignacion),
Estado_Asignacion boolean not null default false,
Encargado int not null references Personal(Id_Personal),
Fecha_Inicio date not null default current_date,
Fecha_Fin date not null,
SueldoTotal numeric(8,2) not null
);

create view Vista_Asignaciones
as
select Id_Asignaciones,Nombre_Proyecto,asi.Asignacion,Estado_Asignacion,pe.Nombre,pe.Apellido,Fecha_Inicio,Fecha_Fin,pe.Sueldo,a.SueldoTotal,pe.DUI
from Asignaciones_Proyecto a,Proyecto p,Personal pe,Asignaciones asi
where a.Encargado = pe.Id_Personal and a.Asignacion = asi.Id_Asignacion and a.Proyecto = p.Id_Proyecto

create view Vista_Actividades
as
select Id_Asignaciones,p.Nombre_Proyecto,a.Asignacion,Estado_Asignacion,concat(pe.Nombre,' ',pe.Apellido) as Encargado,Fecha_Inicio,Fecha_Fin,pe.DUI
from Asignaciones_Proyecto ap,Asignaciones a,Proyecto p,Personal pe
where ap.Asignacion = a.Id_Asignacion and ap.Proyecto = p.Id_Proyecto and ap.Encargado = pe.Id_Personal 

create table Unidad_Medida(
Id_UnidadMedida serial not null primary key,
Unidad_Medida varchar(20) not null
);

CREATE TABLE Materiales(
Id_Material serial not null primary key,
Unidad int not null REFERENCES Unidad_Medida(Id_UnidadMedida),
Estado boolean not null default false,
Nombre_Material varchar(30) not null,
Descripcion varchar(40) not null,
Cantidad_Disponible int not null default 0,
Foto_Material bytea not null default 'nada'
);

create view Vista_Materiales
as
select m.Id_Material,u.Unidad_Medida,m.Nombre_Material,m.Descripcion,m.Foto_Material,m.Estado,m.Cantidad_Disponible
from Materiales m,Unidad_Medida u
where m.Unidad = u.Id_UnidadMedida

CREATE TABLE Compras_Materiales(
Id_Compra serial not null primary key,
Material int not null references Materiales(Id_Material),
Proveedor int not null references Empresa(Id_Empresa),
Encargado int not null references Usuario(Id_Usuario),
Cantidad_Comprada int not null default 0,
Monto_Total numeric(7,2) not null default 0,
Precio_Unitario numeric(7,2) not null default 0,
Fecha_Compra timestamp not null default current_timestamp
);

create view Vista_CompraMaterial
as
select cm.Id_Compra,m.Nombre_Material,u.Usuario,e.Nombre as Proveedor,cm.Cantidad_Comprada,cm.Precio_Unitario,Monto_Total,Cantidad_Disponible,m.Estado,Uni.Unidad_Medida,Fecha_Compra
from Compras_Materiales cm ,Materiales m,Usuario u,Unidad_Medida uni,Empresa e
where m.Unidad = uni.Id_UnidadMedida and cm.Material = m.Id_Material and cm.Encargado = u.Id_Usuario and cm.Proveedor = e.Id_Empresa 

CREATE TABLE Presupuesto_Proyecto(
Id_Presupuesto serial not null primary key,
Proyecto int not null REFERENCES Proyecto(Id_Proyecto) UNIQUE,
Gastos_Preliminares numeric(10,2) null default 0,
Mano_Obra numeric(10,2) null default 0, 
Precio_Materiales numeric(10,2) null default 0,
SubTotal numeric(10,2) null default 0,
Impuestos numeric(10,2) null default 0,
Monto_Total numeric(12,2) null default 0,
Fecha_Modificacion timestamp null default current_timestamp
);

create function actualizarGastoPreliminares(var_presupuesto int) returns void 
as
$$
declare 
gasto numeric(8,2) := (select sum(Precio_Total) from Gastos_Preliminares where Presupuesto = var_presupuesto);
begin
IF gasto = null THEN
gasto = 0;
END IF; 
update Presupuesto_Proyecto set Gastos_Preliminares = gasto where Id_Presupuesto = var_presupuesto;
end 
$$
Language plpgsql;

create function actualizarGastoMaterial(var_presupuesto int) returns void 
as
$$
declare 
gasto numeric(8,2) := (select sum(Precio_Total) from Gastos_Materiales where Presupuesto = var_presupuesto);
begin
IF gasto = null THEN
gasto = 0;
END IF; 
update Presupuesto_Proyecto set Precio_Materiales = gasto where Id_Presupuesto = var_presupuesto;
end 
$$
Language plpgsql;

create function actualizarManoObra(var_presupuesto int,var_proyecto int) returns void 
as 
$$
	declare 
	gasto numeric(8,2) := (select sum(SueldoTotal) from Asignaciones_Proyecto where Proyecto = var_proyecto);
begin
	IF gasto = null THEN
  	gasto = 0;
	END IF;
	update Presupuesto_Proyecto set Mano_Obra = gasto where Id_Presupuesto = var_presupuesto;
End
$$
Language plpgsql; 

create function actualizarTotales(idPresupuesto int) returns void 
as 
$$
	declare 
	var_subTotal numeric(8,2) := (select SUM(Instalaciones+Gastos_Preliminares+Mano_Obra+Precio_Materiales) from Presupuesto_Proyecto where Id_Presupuesto = idPresupuesto );
	impuesto numeric(8,2) := (var_subTotal*13)/100;
	total numeric(10,2) := (var_subTotal + impuesto);
begin
	update Presupuesto_Proyecto set SubTotal = var_subTotal , Impuestos = impuesto , Monto_Total = total, Fecha_Modificacion = current_timestamp
where Id_Presupuesto = idPresupuesto;
End
$$
Language plpgsql; 

create function ingresarCantidadAlmacenaje(v_cantidad int, idMaterial int) returns void 
as 
$$
	declare 
	var_Estado bool;
	CantidadBodega int := (select Cantidad_Disponible from Materiales where Id_Material = idMaterial);
	Cantidad int:= (CantidadBodega + v_cantidad);
begin
	IF Cantidad <= 0 THEN
  	var_Estado := false;
	ELSE
	var_Estado := true;
	END IF;
	update Materiales set Cantidad_Disponible = Cantidad , Estado = var_Estado where Id_Material = idMaterial;
End
$$
Language plpgsql; 

create function crearPresupuesto() returns Trigger
as 
$$
Declare 
Proyecto int:= (select max(Id_Proyecto) from Proyecto);
Begin
insert into Presupuesto_Proyecto values(default,Proyecto,default,default,default,default,default,default);
return new;
End
$$
Language plpgsql; 

CREATE TRIGGER insert_crearPresupuesto 
after insert on Proyecto
for each row
execute procedure crearPresupuesto();

CREATE TABLE Gastos_Preliminares(
Id_GastoPreliminar serial not null primary key,
Presupuesto int not null references Presupuesto_Proyecto(Id_Presupuesto),
Gasto varchar(30) not null,
Precio_Total numeric(9,2) not null default 0,
Descripcion varchar(150) not null
);

create view Vista_GastosPreliminares
as
select Id_GastoPreliminar,Presupuesto,Gasto,Precio_Total,Descripcion
from Gastos_Preliminares 

CREATE TABLE Gastos_Materiales(
Id_GastoMateriales serial not null primary key,
Presupuesto int not null references Presupuesto_Proyecto(Id_Presupuesto),
Material int not null references Materiales(Id_Material),
Cantidad numeric(6) not null default 0,
Precio_Total numeric(9,2) not null default 0,
Fecha_Modificacion timestamp not null default current_timestamp
);

create view Vista_GastoMateriales
as
select id_gastomateriales,presupuesto,m.nombre_material,cantidad,Precio_Total,u.unidad_medida,m.cantidad_disponible
from Gastos_Materiales gm,Materiales m, unidad_medida u
where gm.Material = m.id_material and m.unidad = u.id_unidadmedida