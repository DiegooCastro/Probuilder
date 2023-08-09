PGDMP         #                {            db_probuilder    15.3    15.3 �               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24672    db_probuilder    DATABASE     �   CREATE DATABASE db_probuilder WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_El Salvador.1252';
    DROP DATABASE db_probuilder;
                postgres    false                       1255    24966     actualizargastomaterial(integer)    FUNCTION     �  CREATE FUNCTION public.actualizargastomaterial(var_presupuesto integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
declare 
gasto numeric(8,2) := (select sum(Precio_Total) from Gastos_Materiales where Presupuesto = var_presupuesto);
begin
IF gasto = null THEN
gasto = 0;
END IF; 
update Presupuesto_Proyecto set Precio_Materiales = gasto where Id_Presupuesto = var_presupuesto;
end 
$$;
 G   DROP FUNCTION public.actualizargastomaterial(var_presupuesto integer);
       public          postgres    false                       1255    24965 $   actualizargastopreliminares(integer)    FUNCTION     �  CREATE FUNCTION public.actualizargastopreliminares(var_presupuesto integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
declare 
gasto numeric(8,2) := (select sum(Precio_Total) from Gastos_Preliminares where Presupuesto = var_presupuesto);
begin
IF gasto = null THEN
gasto = 0;
END IF; 
update Presupuesto_Proyecto set Gastos_Preliminares = gasto where Id_Presupuesto = var_presupuesto;
end 
$$;
 K   DROP FUNCTION public.actualizargastopreliminares(var_presupuesto integer);
       public          postgres    false                       1255    24967 $   actualizarmanoobra(integer, integer)    FUNCTION     �  CREATE FUNCTION public.actualizarmanoobra(var_presupuesto integer, var_proyecto integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
	declare 
	gasto numeric(8,2) := (select sum(SueldoTotal) from Asignaciones_Proyecto where Proyecto = var_proyecto);
begin
	IF gasto = null THEN
  	gasto = 0;
	END IF;
	update Presupuesto_Proyecto set Mano_Obra = gasto where Id_Presupuesto = var_presupuesto;
End
$$;
 X   DROP FUNCTION public.actualizarmanoobra(var_presupuesto integer, var_proyecto integer);
       public          postgres    false                       1255    24968    actualizartotales(integer)    FUNCTION     G  CREATE FUNCTION public.actualizartotales(idpresupuesto integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
	declare 
	var_subTotal numeric(8,2) := (select SUM(Instalaciones+Gastos_Preliminares+Mano_Obra+Precio_Materiales) from Presupuesto_Proyecto where Id_Presupuesto = idPresupuesto );
	impuesto numeric(8,2) := (var_subTotal*13)/100;
	total numeric(10,2) := (var_subTotal + impuesto);
begin
	update Presupuesto_Proyecto set SubTotal = var_subTotal , Impuestos = impuesto , Monto_Total = total, Fecha_Modificacion = current_timestamp
where Id_Presupuesto = idPresupuesto;
End
$$;
 ?   DROP FUNCTION public.actualizartotales(idpresupuesto integer);
       public          postgres    false            
           1255    24970    crearpresupuesto()    FUNCTION       CREATE FUNCTION public.crearpresupuesto() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
Declare 
Proyecto int:= (select max(Id_Proyecto) from Proyecto);
Begin
insert into Presupuesto_Proyecto values(default,Proyecto,default,default,default,default,default,default);
return new;
End
$$;
 )   DROP FUNCTION public.crearpresupuesto();
       public          postgres    false            	           1255    24969 ,   ingresarcantidadalmacenaje(integer, integer)    FUNCTION       CREATE FUNCTION public.ingresarcantidadalmacenaje(v_cantidad integer, idmaterial integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
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
$$;
 Y   DROP FUNCTION public.ingresarcantidadalmacenaje(v_cantidad integer, idmaterial integer);
       public          postgres    false            �            1259    24797    asignaciones    TABLE     x   CREATE TABLE public.asignaciones (
    id_asignacion integer NOT NULL,
    asignacion character varying(40) NOT NULL
);
     DROP TABLE public.asignaciones;
       public         heap    postgres    false            �            1259    24796    asignaciones_id_asignacion_seq    SEQUENCE     �   CREATE SEQUENCE public.asignaciones_id_asignacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.asignaciones_id_asignacion_seq;
       public          postgres    false    233                       0    0    asignaciones_id_asignacion_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.asignaciones_id_asignacion_seq OWNED BY public.asignaciones.id_asignacion;
          public          postgres    false    232            �            1259    24853    asignaciones_proyecto    TABLE     c  CREATE TABLE public.asignaciones_proyecto (
    id_asignaciones integer NOT NULL,
    proyecto integer NOT NULL,
    asignacion integer NOT NULL,
    estado_asignacion boolean DEFAULT false NOT NULL,
    encargado integer NOT NULL,
    fecha_inicio date DEFAULT CURRENT_DATE NOT NULL,
    fecha_fin date NOT NULL,
    sueldototal numeric(8,2) NOT NULL
);
 )   DROP TABLE public.asignaciones_proyecto;
       public         heap    postgres    false            �            1259    24852 )   asignaciones_proyecto_id_asignaciones_seq    SEQUENCE     �   CREATE SEQUENCE public.asignaciones_proyecto_id_asignaciones_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 @   DROP SEQUENCE public.asignaciones_proyecto_id_asignaciones_seq;
       public          postgres    false    242                       0    0 )   asignaciones_proyecto_id_asignaciones_seq    SEQUENCE OWNED BY     w   ALTER SEQUENCE public.asignaciones_proyecto_id_asignaciones_seq OWNED BY public.asignaciones_proyecto.id_asignaciones;
          public          postgres    false    241            �            1259    24781    cliente    TABLE     )  CREATE TABLE public.cliente (
    id_cliente integer NOT NULL,
    empresa integer NOT NULL,
    nombre character varying(40) NOT NULL,
    apellido character varying(40) NOT NULL,
    telefono character(9) NOT NULL,
    dui character(10) NOT NULL,
    correo_electronico character varying(50)
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    24780    cliente_id_cliente_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_id_cliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.cliente_id_cliente_seq;
       public          postgres    false    230                       0    0    cliente_id_cliente_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.cliente_id_cliente_seq OWNED BY public.cliente.id_cliente;
          public          postgres    false    229            �            1259    24913    compras_materiales    TABLE     �  CREATE TABLE public.compras_materiales (
    id_compra integer NOT NULL,
    material integer NOT NULL,
    proveedor integer NOT NULL,
    encargado integer NOT NULL,
    cantidad_comprada integer DEFAULT 0 NOT NULL,
    monto_total numeric(7,2) DEFAULT 0 NOT NULL,
    precio_unitario numeric(7,2) DEFAULT 0 NOT NULL,
    fecha_compra timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);
 &   DROP TABLE public.compras_materiales;
       public         heap    postgres    false            �            1259    24912     compras_materiales_id_compra_seq    SEQUENCE     �   CREATE SEQUENCE public.compras_materiales_id_compra_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.compras_materiales_id_compra_seq;
       public          postgres    false    251                       0    0     compras_materiales_id_compra_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.compras_materiales_id_compra_seq OWNED BY public.compras_materiales.id_compra;
          public          postgres    false    250            �            1259    24695    empresa    TABLE     0  CREATE TABLE public.empresa (
    id_empresa integer NOT NULL,
    tipo integer NOT NULL,
    nombre character varying(40) NOT NULL,
    ubicacion character varying(75) NOT NULL,
    telefono character(9) NOT NULL,
    correo character varying(60) NOT NULL,
    telefono2 character(9),
    logo bytea
);
    DROP TABLE public.empresa;
       public         heap    postgres    false            �            1259    24694    empresa_id_empresa_seq    SEQUENCE     �   CREATE SEQUENCE public.empresa_id_empresa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.empresa_id_empresa_seq;
       public          postgres    false    221                        0    0    empresa_id_empresa_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.empresa_id_empresa_seq OWNED BY public.empresa.id_empresa;
          public          postgres    false    220            �            1259    24839    fotografias    TABLE     }   CREATE TABLE public.fotografias (
    id_fotografia integer NOT NULL,
    proyecto integer NOT NULL,
    fotografia bytea
);
    DROP TABLE public.fotografias;
       public         heap    postgres    false            �            1259    24838    fotografias_id_fotografia_seq    SEQUENCE     �   CREATE SEQUENCE public.fotografias_id_fotografia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.fotografias_id_fotografia_seq;
       public          postgres    false    240            !           0    0    fotografias_id_fotografia_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.fotografias_id_fotografia_seq OWNED BY public.fotografias.id_fotografia;
          public          postgres    false    239                       1259    24990    gastos_materiales    TABLE     K  CREATE TABLE public.gastos_materiales (
    id_gastomateriales integer NOT NULL,
    presupuesto integer NOT NULL,
    material integer NOT NULL,
    cantidad numeric(6,0) DEFAULT 0 NOT NULL,
    precio_total numeric(9,2) DEFAULT 0 NOT NULL,
    fecha_modificacion timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);
 %   DROP TABLE public.gastos_materiales;
       public         heap    postgres    false                       1259    24989 (   gastos_materiales_id_gastomateriales_seq    SEQUENCE     �   CREATE SEQUENCE public.gastos_materiales_id_gastomateriales_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ?   DROP SEQUENCE public.gastos_materiales_id_gastomateriales_seq;
       public          postgres    false    259            "           0    0 (   gastos_materiales_id_gastomateriales_seq    SEQUENCE OWNED BY     u   ALTER SEQUENCE public.gastos_materiales_id_gastomateriales_seq OWNED BY public.gastos_materiales.id_gastomateriales;
          public          postgres    false    258                        1259    24973    gastos_preliminares    TABLE       CREATE TABLE public.gastos_preliminares (
    id_gastopreliminar integer NOT NULL,
    presupuesto integer NOT NULL,
    gasto character varying(30) NOT NULL,
    precio_total numeric(9,2) DEFAULT 0 NOT NULL,
    descripcion character varying(150) NOT NULL
);
 '   DROP TABLE public.gastos_preliminares;
       public         heap    postgres    false            �            1259    24972 *   gastos_preliminares_id_gastopreliminar_seq    SEQUENCE     �   CREATE SEQUENCE public.gastos_preliminares_id_gastopreliminar_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 A   DROP SEQUENCE public.gastos_preliminares_id_gastopreliminar_seq;
       public          postgres    false    256            #           0    0 *   gastos_preliminares_id_gastopreliminar_seq    SEQUENCE OWNED BY     y   ALTER SEQUENCE public.gastos_preliminares_id_gastopreliminar_seq OWNED BY public.gastos_preliminares.id_gastopreliminar;
          public          postgres    false    255            �            1259    24892 
   materiales    TABLE     c  CREATE TABLE public.materiales (
    id_material integer NOT NULL,
    unidad integer NOT NULL,
    estado boolean DEFAULT false NOT NULL,
    nombre_material character varying(30) NOT NULL,
    descripcion character varying(40) NOT NULL,
    cantidad_disponible integer DEFAULT 0 NOT NULL,
    foto_material bytea DEFAULT '\x6e616461'::bytea NOT NULL
);
    DROP TABLE public.materiales;
       public         heap    postgres    false            �            1259    24891    materiales_id_material_seq    SEQUENCE     �   CREATE SEQUENCE public.materiales_id_material_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.materiales_id_material_seq;
       public          postgres    false    248            $           0    0    materiales_id_material_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.materiales_id_material_seq OWNED BY public.materiales.id_material;
          public          postgres    false    247            �            1259    24713    personal    TABLE     U  CREATE TABLE public.personal (
    id_personal integer NOT NULL,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    telefono character(9) NOT NULL,
    dui character(10) NOT NULL,
    profesion integer NOT NULL,
    estado boolean DEFAULT true NOT NULL,
    sueldo numeric(8,2) DEFAULT 0 NOT NULL
);
    DROP TABLE public.personal;
       public         heap    postgres    false            �            1259    24712    personal_id_personal_seq    SEQUENCE     �   CREATE SEQUENCE public.personal_id_personal_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.personal_id_personal_seq;
       public          postgres    false    224            %           0    0    personal_id_personal_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.personal_id_personal_seq OWNED BY public.personal.id_personal;
          public          postgres    false    223            �            1259    24945    presupuesto_proyecto    TABLE     �  CREATE TABLE public.presupuesto_proyecto (
    id_presupuesto integer NOT NULL,
    proyecto integer NOT NULL,
    gastos_preliminares numeric(10,2) DEFAULT 0,
    mano_obra numeric(10,2) DEFAULT 0,
    precio_materiales numeric(10,2) DEFAULT 0,
    subtotal numeric(10,2) DEFAULT 0,
    impuestos numeric(10,2) DEFAULT 0,
    monto_total numeric(12,2) DEFAULT 0,
    fecha_modificacion timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 (   DROP TABLE public.presupuesto_proyecto;
       public         heap    postgres    false            �            1259    24944 '   presupuesto_proyecto_id_presupuesto_seq    SEQUENCE     �   CREATE SEQUENCE public.presupuesto_proyecto_id_presupuesto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 >   DROP SEQUENCE public.presupuesto_proyecto_id_presupuesto_seq;
       public          postgres    false    254            &           0    0 '   presupuesto_proyecto_id_presupuesto_seq    SEQUENCE OWNED BY     s   ALTER SEQUENCE public.presupuesto_proyecto_id_presupuesto_seq OWNED BY public.presupuesto_proyecto.id_presupuesto;
          public          postgres    false    253            �            1259    24674 	   profesion    TABLE     s   CREATE TABLE public.profesion (
    id_profesion integer NOT NULL,
    profesion character varying(40) NOT NULL
);
    DROP TABLE public.profesion;
       public         heap    postgres    false            �            1259    24673    profesion_id_profesion_seq    SEQUENCE     �   CREATE SEQUENCE public.profesion_id_profesion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.profesion_id_profesion_seq;
       public          postgres    false    215            '           0    0    profesion_id_profesion_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.profesion_id_profesion_seq OWNED BY public.profesion.id_profesion;
          public          postgres    false    214            �            1259    24811    proyecto    TABLE     �  CREATE TABLE public.proyecto (
    id_proyecto integer NOT NULL,
    estado boolean DEFAULT false NOT NULL,
    cliente integer NOT NULL,
    supervisor integer NOT NULL,
    tipo_proyecto integer NOT NULL,
    nombre_proyecto character varying(40) NOT NULL,
    ubicacion character varying(100),
    descripcion_proyecto character varying(150),
    fechainicio date DEFAULT CURRENT_DATE NOT NULL,
    fechafin date NOT NULL
);
    DROP TABLE public.proyecto;
       public         heap    postgres    false            �            1259    24810    proyecto_id_proyecto_seq    SEQUENCE     �   CREATE SEQUENCE public.proyecto_id_proyecto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.proyecto_id_proyecto_seq;
       public          postgres    false    237            (           0    0    proyecto_id_proyecto_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.proyecto_id_proyecto_seq OWNED BY public.proyecto.id_proyecto;
          public          postgres    false    236            �            1259    24688    tipo_empresa    TABLE     {   CREATE TABLE public.tipo_empresa (
    id_tipoempresa integer NOT NULL,
    tipo_empresa character varying(30) NOT NULL
);
     DROP TABLE public.tipo_empresa;
       public         heap    postgres    false            �            1259    24687    tipo_empresa_id_tipoempresa_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_empresa_id_tipoempresa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.tipo_empresa_id_tipoempresa_seq;
       public          postgres    false    219            )           0    0    tipo_empresa_id_tipoempresa_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.tipo_empresa_id_tipoempresa_seq OWNED BY public.tipo_empresa.id_tipoempresa;
          public          postgres    false    218            �            1259    24804    tipo_proyecto    TABLE     ~   CREATE TABLE public.tipo_proyecto (
    id_tipoproyecto integer NOT NULL,
    tipo_proyecto character varying(30) NOT NULL
);
 !   DROP TABLE public.tipo_proyecto;
       public         heap    postgres    false            �            1259    24803 !   tipo_proyecto_id_tipoproyecto_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_proyecto_id_tipoproyecto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.tipo_proyecto_id_tipoproyecto_seq;
       public          postgres    false    235            *           0    0 !   tipo_proyecto_id_tipoproyecto_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.tipo_proyecto_id_tipoproyecto_seq OWNED BY public.tipo_proyecto.id_tipoproyecto;
          public          postgres    false    234            �            1259    24681    tipo_usuario    TABLE     t   CREATE TABLE public.tipo_usuario (
    id_tipo integer NOT NULL,
    tipo_usuario character varying(40) NOT NULL
);
     DROP TABLE public.tipo_usuario;
       public         heap    postgres    false            �            1259    24680    tipo_usuario_id_tipo_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_usuario_id_tipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.tipo_usuario_id_tipo_seq;
       public          postgres    false    217            +           0    0    tipo_usuario_id_tipo_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.tipo_usuario_id_tipo_seq OWNED BY public.tipo_usuario.id_tipo;
          public          postgres    false    216            �            1259    24885    unidad_medida    TABLE     ~   CREATE TABLE public.unidad_medida (
    id_unidadmedida integer NOT NULL,
    unidad_medida character varying(20) NOT NULL
);
 !   DROP TABLE public.unidad_medida;
       public         heap    postgres    false            �            1259    24884 !   unidad_medida_id_unidadmedida_seq    SEQUENCE     �   CREATE SEQUENCE public.unidad_medida_id_unidadmedida_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.unidad_medida_id_unidadmedida_seq;
       public          postgres    false    246            ,           0    0 !   unidad_medida_id_unidadmedida_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.unidad_medida_id_unidadmedida_seq OWNED BY public.unidad_medida.id_unidadmedida;
          public          postgres    false    245            �            1259    24756    usuario    TABLE     r  CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    tipo integer NOT NULL,
    trabajador integer NOT NULL,
    estado boolean DEFAULT true NOT NULL,
    usuario character varying(40) NOT NULL,
    clave character varying(75) DEFAULT '9b280cdab8a415d8ab17414be48e9aa7'::character varying NOT NULL,
    correo_electronico character varying(75) NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    24755    usuario_id_usuario_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.usuario_id_usuario_seq;
       public          postgres    false    227            -           0    0    usuario_id_usuario_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;
          public          postgres    false    226            �            1259    24880    vista_actividades    VIEW     �  CREATE VIEW public.vista_actividades AS
 SELECT ap.id_asignaciones,
    p.nombre_proyecto,
    a.asignacion,
    ap.estado_asignacion,
    concat(pe.nombre, ' ', pe.apellido) AS encargado,
    ap.fecha_inicio,
    ap.fecha_fin,
    pe.dui
   FROM public.asignaciones_proyecto ap,
    public.asignaciones a,
    public.proyecto p,
    public.personal pe
  WHERE ((ap.asignacion = a.id_asignacion) AND (ap.proyecto = p.id_proyecto) AND (ap.encargado = pe.id_personal));
 $   DROP VIEW public.vista_actividades;
       public          postgres    false    242    242    242    242    242    242    242    237    237    233    233    224    224    224    224            �            1259    24876    vista_asignaciones    VIEW     �  CREATE VIEW public.vista_asignaciones AS
 SELECT a.id_asignaciones,
    p.nombre_proyecto,
    asi.asignacion,
    a.estado_asignacion,
    pe.nombre,
    pe.apellido,
    a.fecha_inicio,
    a.fecha_fin,
    pe.sueldo,
    a.sueldototal,
    pe.dui
   FROM public.asignaciones_proyecto a,
    public.proyecto p,
    public.personal pe,
    public.asignaciones asi
  WHERE ((a.encargado = pe.id_personal) AND (a.asignacion = asi.id_asignacion) AND (a.proyecto = p.id_proyecto));
 %   DROP VIEW public.vista_asignaciones;
       public          postgres    false    224    224    224    224    233    233    237    237    242    242    242    242    242    242    242    242    224            �            1259    24792    vista_cliente    VIEW     �   CREATE VIEW public.vista_cliente AS
 SELECT c.id_cliente,
    e.nombre AS empresa,
    c.nombre,
    c.apellido,
    c.telefono,
    c.dui,
    c.correo_electronico
   FROM public.cliente c,
    public.empresa e
  WHERE (c.empresa = e.id_empresa);
     DROP VIEW public.vista_cliente;
       public          postgres    false    230    230    230    221    230    221    230    230    230            �            1259    24938    vista_compramaterial    VIEW     6  CREATE VIEW public.vista_compramaterial AS
 SELECT cm.id_compra,
    m.nombre_material,
    u.usuario,
    e.nombre AS proveedor,
    cm.cantidad_comprada,
    cm.precio_unitario,
    cm.monto_total,
    m.cantidad_disponible,
    m.estado,
    uni.unidad_medida,
    cm.fecha_compra
   FROM public.compras_materiales cm,
    public.materiales m,
    public.usuario u,
    public.unidad_medida uni,
    public.empresa e
  WHERE ((m.unidad = uni.id_unidadmedida) AND (cm.material = m.id_material) AND (cm.encargado = u.id_usuario) AND (cm.proveedor = e.id_empresa));
 '   DROP VIEW public.vista_compramaterial;
       public          postgres    false    221    221    227    227    246    246    248    248    248    248    248    251    251    251    251    251    251    251    251            �            1259    24708    vista_empresa    VIEW     .  CREATE VIEW public.vista_empresa AS
 SELECT empresa.id_empresa,
    t.tipo_empresa,
    empresa.nombre,
    empresa.ubicacion,
    empresa.telefono,
    empresa.correo,
    empresa.telefono2,
    empresa.logo
   FROM public.empresa,
    public.tipo_empresa t
  WHERE (empresa.tipo = t.id_tipoempresa);
     DROP VIEW public.vista_empresa;
       public          postgres    false    221    219    221    221    219    221    221    221    221    221                       1259    25009    vista_gastomateriales    VIEW     p  CREATE VIEW public.vista_gastomateriales AS
 SELECT gm.id_gastomateriales,
    gm.presupuesto,
    m.nombre_material,
    gm.cantidad,
    gm.precio_total,
    u.unidad_medida,
    m.cantidad_disponible
   FROM public.gastos_materiales gm,
    public.materiales m,
    public.unidad_medida u
  WHERE ((gm.material = m.id_material) AND (m.unidad = u.id_unidadmedida));
 (   DROP VIEW public.vista_gastomateriales;
       public          postgres    false    248    246    259    259    259    248    246    248    259    248    259                       1259    24985    vista_gastospreliminares    VIEW       CREATE VIEW public.vista_gastospreliminares AS
 SELECT gastos_preliminares.id_gastopreliminar,
    gastos_preliminares.presupuesto,
    gastos_preliminares.gasto,
    gastos_preliminares.precio_total,
    gastos_preliminares.descripcion
   FROM public.gastos_preliminares;
 +   DROP VIEW public.vista_gastospreliminares;
       public          postgres    false    256    256    256    256    256            �            1259    24908    vista_materiales    VIEW       CREATE VIEW public.vista_materiales AS
 SELECT m.id_material,
    u.unidad_medida,
    m.nombre_material,
    m.descripcion,
    m.foto_material,
    m.estado,
    m.cantidad_disponible
   FROM public.materiales m,
    public.unidad_medida u
  WHERE (m.unidad = u.id_unidadmedida);
 #   DROP VIEW public.vista_materiales;
       public          postgres    false    248    248    248    248    248    248    248    246    246            �            1259    24730    vista_personal    VIEW       CREATE VIEW public.vista_personal AS
 SELECT pe.id_personal,
    p.profesion,
    pe.estado,
    pe.nombre,
    pe.apellido,
    pe.telefono,
    pe.dui,
    pe.sueldo
   FROM public.personal pe,
    public.profesion p
  WHERE (pe.profesion = p.id_profesion);
 !   DROP VIEW public.vista_personal;
       public          postgres    false    224    224    224    215    215    224    224    224    224    224            �            1259    24834    vista_proyecto    VIEW     �  CREATE VIEW public.vista_proyecto AS
 SELECT p.id_proyecto,
    p.estado,
    c.nombre,
    c.apellido,
    u.usuario,
    t.tipo_proyecto,
    p.nombre_proyecto,
    p.ubicacion,
    p.descripcion_proyecto,
    p.fechainicio,
    p.fechafin
   FROM public.proyecto p,
    public.cliente c,
    public.usuario u,
    public.tipo_proyecto t
  WHERE ((c.id_cliente = p.cliente) AND (t.id_tipoproyecto = p.tipo_proyecto) AND (p.supervisor = u.id_usuario));
 !   DROP VIEW public.vista_proyecto;
       public          postgres    false    237    227    227    230    230    230    235    237    237    237    237    237    235    237    237    237    237            �            1259    24776    vista_usuario    VIEW     H  CREATE VIEW public.vista_usuario AS
 SELECT u.id_usuario,
    u.estado,
    u.usuario,
    u.clave,
    u.correo_electronico,
    p.nombre,
    p.apellido,
    p.dui,
    t.tipo_usuario
   FROM public.usuario u,
    public.personal p,
    public.tipo_usuario t
  WHERE ((u.trabajador = p.id_personal) AND (t.id_tipo = u.tipo));
     DROP VIEW public.vista_usuario;
       public          postgres    false    224    224    217    227    227    227    227    217    227    227    227    224    224            �           2604    24800    asignaciones id_asignacion    DEFAULT     �   ALTER TABLE ONLY public.asignaciones ALTER COLUMN id_asignacion SET DEFAULT nextval('public.asignaciones_id_asignacion_seq'::regclass);
 I   ALTER TABLE public.asignaciones ALTER COLUMN id_asignacion DROP DEFAULT;
       public          postgres    false    233    232    233            �           2604    24856 %   asignaciones_proyecto id_asignaciones    DEFAULT     �   ALTER TABLE ONLY public.asignaciones_proyecto ALTER COLUMN id_asignaciones SET DEFAULT nextval('public.asignaciones_proyecto_id_asignaciones_seq'::regclass);
 T   ALTER TABLE public.asignaciones_proyecto ALTER COLUMN id_asignaciones DROP DEFAULT;
       public          postgres    false    242    241    242            �           2604    24784    cliente id_cliente    DEFAULT     x   ALTER TABLE ONLY public.cliente ALTER COLUMN id_cliente SET DEFAULT nextval('public.cliente_id_cliente_seq'::regclass);
 A   ALTER TABLE public.cliente ALTER COLUMN id_cliente DROP DEFAULT;
       public          postgres    false    229    230    230                       2604    24916    compras_materiales id_compra    DEFAULT     �   ALTER TABLE ONLY public.compras_materiales ALTER COLUMN id_compra SET DEFAULT nextval('public.compras_materiales_id_compra_seq'::regclass);
 K   ALTER TABLE public.compras_materiales ALTER COLUMN id_compra DROP DEFAULT;
       public          postgres    false    251    250    251            �           2604    24698    empresa id_empresa    DEFAULT     x   ALTER TABLE ONLY public.empresa ALTER COLUMN id_empresa SET DEFAULT nextval('public.empresa_id_empresa_seq'::regclass);
 A   ALTER TABLE public.empresa ALTER COLUMN id_empresa DROP DEFAULT;
       public          postgres    false    221    220    221            �           2604    24842    fotografias id_fotografia    DEFAULT     �   ALTER TABLE ONLY public.fotografias ALTER COLUMN id_fotografia SET DEFAULT nextval('public.fotografias_id_fotografia_seq'::regclass);
 H   ALTER TABLE public.fotografias ALTER COLUMN id_fotografia DROP DEFAULT;
       public          postgres    false    239    240    240                       2604    24993 $   gastos_materiales id_gastomateriales    DEFAULT     �   ALTER TABLE ONLY public.gastos_materiales ALTER COLUMN id_gastomateriales SET DEFAULT nextval('public.gastos_materiales_id_gastomateriales_seq'::regclass);
 S   ALTER TABLE public.gastos_materiales ALTER COLUMN id_gastomateriales DROP DEFAULT;
       public          postgres    false    258    259    259                       2604    24976 &   gastos_preliminares id_gastopreliminar    DEFAULT     �   ALTER TABLE ONLY public.gastos_preliminares ALTER COLUMN id_gastopreliminar SET DEFAULT nextval('public.gastos_preliminares_id_gastopreliminar_seq'::regclass);
 U   ALTER TABLE public.gastos_preliminares ALTER COLUMN id_gastopreliminar DROP DEFAULT;
       public          postgres    false    255    256    256                       2604    24895    materiales id_material    DEFAULT     �   ALTER TABLE ONLY public.materiales ALTER COLUMN id_material SET DEFAULT nextval('public.materiales_id_material_seq'::regclass);
 E   ALTER TABLE public.materiales ALTER COLUMN id_material DROP DEFAULT;
       public          postgres    false    247    248    248            �           2604    24716    personal id_personal    DEFAULT     |   ALTER TABLE ONLY public.personal ALTER COLUMN id_personal SET DEFAULT nextval('public.personal_id_personal_seq'::regclass);
 C   ALTER TABLE public.personal ALTER COLUMN id_personal DROP DEFAULT;
       public          postgres    false    224    223    224            
           2604    24948 #   presupuesto_proyecto id_presupuesto    DEFAULT     �   ALTER TABLE ONLY public.presupuesto_proyecto ALTER COLUMN id_presupuesto SET DEFAULT nextval('public.presupuesto_proyecto_id_presupuesto_seq'::regclass);
 R   ALTER TABLE public.presupuesto_proyecto ALTER COLUMN id_presupuesto DROP DEFAULT;
       public          postgres    false    253    254    254            �           2604    24677    profesion id_profesion    DEFAULT     �   ALTER TABLE ONLY public.profesion ALTER COLUMN id_profesion SET DEFAULT nextval('public.profesion_id_profesion_seq'::regclass);
 E   ALTER TABLE public.profesion ALTER COLUMN id_profesion DROP DEFAULT;
       public          postgres    false    214    215    215            �           2604    24814    proyecto id_proyecto    DEFAULT     |   ALTER TABLE ONLY public.proyecto ALTER COLUMN id_proyecto SET DEFAULT nextval('public.proyecto_id_proyecto_seq'::regclass);
 C   ALTER TABLE public.proyecto ALTER COLUMN id_proyecto DROP DEFAULT;
       public          postgres    false    236    237    237            �           2604    24691    tipo_empresa id_tipoempresa    DEFAULT     �   ALTER TABLE ONLY public.tipo_empresa ALTER COLUMN id_tipoempresa SET DEFAULT nextval('public.tipo_empresa_id_tipoempresa_seq'::regclass);
 J   ALTER TABLE public.tipo_empresa ALTER COLUMN id_tipoempresa DROP DEFAULT;
       public          postgres    false    219    218    219            �           2604    24807    tipo_proyecto id_tipoproyecto    DEFAULT     �   ALTER TABLE ONLY public.tipo_proyecto ALTER COLUMN id_tipoproyecto SET DEFAULT nextval('public.tipo_proyecto_id_tipoproyecto_seq'::regclass);
 L   ALTER TABLE public.tipo_proyecto ALTER COLUMN id_tipoproyecto DROP DEFAULT;
       public          postgres    false    235    234    235            �           2604    24684    tipo_usuario id_tipo    DEFAULT     |   ALTER TABLE ONLY public.tipo_usuario ALTER COLUMN id_tipo SET DEFAULT nextval('public.tipo_usuario_id_tipo_seq'::regclass);
 C   ALTER TABLE public.tipo_usuario ALTER COLUMN id_tipo DROP DEFAULT;
       public          postgres    false    216    217    217                        2604    24888    unidad_medida id_unidadmedida    DEFAULT     �   ALTER TABLE ONLY public.unidad_medida ALTER COLUMN id_unidadmedida SET DEFAULT nextval('public.unidad_medida_id_unidadmedida_seq'::regclass);
 L   ALTER TABLE public.unidad_medida ALTER COLUMN id_unidadmedida DROP DEFAULT;
       public          postgres    false    246    245    246            �           2604    24759    usuario id_usuario    DEFAULT     x   ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);
 A   ALTER TABLE public.usuario ALTER COLUMN id_usuario DROP DEFAULT;
       public          postgres    false    227    226    227                      0    24797    asignaciones 
   TABLE DATA           A   COPY public.asignaciones (id_asignacion, asignacion) FROM stdin;
    public          postgres    false    233   ��       	          0    24853    asignaciones_proyecto 
   TABLE DATA           �   COPY public.asignaciones_proyecto (id_asignaciones, proyecto, asignacion, estado_asignacion, encargado, fecha_inicio, fecha_fin, sueldototal) FROM stdin;
    public          postgres    false    242   �       �          0    24781    cliente 
   TABLE DATA           k   COPY public.cliente (id_cliente, empresa, nombre, apellido, telefono, dui, correo_electronico) FROM stdin;
    public          postgres    false    230   �                 0    24913    compras_materiales 
   TABLE DATA           �   COPY public.compras_materiales (id_compra, material, proveedor, encargado, cantidad_comprada, monto_total, precio_unitario, fecha_compra) FROM stdin;
    public          postgres    false    251   ;�       �          0    24695    empresa 
   TABLE DATA           i   COPY public.empresa (id_empresa, tipo, nombre, ubicacion, telefono, correo, telefono2, logo) FROM stdin;
    public          postgres    false    221   X�                 0    24839    fotografias 
   TABLE DATA           J   COPY public.fotografias (id_fotografia, proyecto, fotografia) FROM stdin;
    public          postgres    false    240   u�                 0    24990    gastos_materiales 
   TABLE DATA           �   COPY public.gastos_materiales (id_gastomateriales, presupuesto, material, cantidad, precio_total, fecha_modificacion) FROM stdin;
    public          postgres    false    259   ��                 0    24973    gastos_preliminares 
   TABLE DATA           p   COPY public.gastos_preliminares (id_gastopreliminar, presupuesto, gasto, precio_total, descripcion) FROM stdin;
    public          postgres    false    256   ��                 0    24892 
   materiales 
   TABLE DATA           �   COPY public.materiales (id_material, unidad, estado, nombre_material, descripcion, cantidad_disponible, foto_material) FROM stdin;
    public          postgres    false    248   ��       �          0    24713    personal 
   TABLE DATA           k   COPY public.personal (id_personal, nombre, apellido, telefono, dui, profesion, estado, sueldo) FROM stdin;
    public          postgres    false    224   ��                 0    24945    presupuesto_proyecto 
   TABLE DATA           �   COPY public.presupuesto_proyecto (id_presupuesto, proyecto, gastos_preliminares, mano_obra, precio_materiales, subtotal, impuestos, monto_total, fecha_modificacion) FROM stdin;
    public          postgres    false    254   3�       �          0    24674 	   profesion 
   TABLE DATA           <   COPY public.profesion (id_profesion, profesion) FROM stdin;
    public          postgres    false    215   P�                 0    24811    proyecto 
   TABLE DATA           �   COPY public.proyecto (id_proyecto, estado, cliente, supervisor, tipo_proyecto, nombre_proyecto, ubicacion, descripcion_proyecto, fechainicio, fechafin) FROM stdin;
    public          postgres    false    237   ��       �          0    24688    tipo_empresa 
   TABLE DATA           D   COPY public.tipo_empresa (id_tipoempresa, tipo_empresa) FROM stdin;
    public          postgres    false    219   ��                 0    24804    tipo_proyecto 
   TABLE DATA           G   COPY public.tipo_proyecto (id_tipoproyecto, tipo_proyecto) FROM stdin;
    public          postgres    false    235   ��       �          0    24681    tipo_usuario 
   TABLE DATA           =   COPY public.tipo_usuario (id_tipo, tipo_usuario) FROM stdin;
    public          postgres    false    217   �                 0    24885    unidad_medida 
   TABLE DATA           G   COPY public.unidad_medida (id_unidadmedida, unidad_medida) FROM stdin;
    public          postgres    false    246   D�       �          0    24756    usuario 
   TABLE DATA           k   COPY public.usuario (id_usuario, tipo, trabajador, estado, usuario, clave, correo_electronico) FROM stdin;
    public          postgres    false    227   a�       .           0    0    asignaciones_id_asignacion_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.asignaciones_id_asignacion_seq', 1, true);
          public          postgres    false    232            /           0    0 )   asignaciones_proyecto_id_asignaciones_seq    SEQUENCE SET     X   SELECT pg_catalog.setval('public.asignaciones_proyecto_id_asignaciones_seq', 1, false);
          public          postgres    false    241            0           0    0    cliente_id_cliente_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.cliente_id_cliente_seq', 1, false);
          public          postgres    false    229            1           0    0     compras_materiales_id_compra_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.compras_materiales_id_compra_seq', 1, false);
          public          postgres    false    250            2           0    0    empresa_id_empresa_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.empresa_id_empresa_seq', 1, false);
          public          postgres    false    220            3           0    0    fotografias_id_fotografia_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.fotografias_id_fotografia_seq', 1, false);
          public          postgres    false    239            4           0    0 (   gastos_materiales_id_gastomateriales_seq    SEQUENCE SET     W   SELECT pg_catalog.setval('public.gastos_materiales_id_gastomateriales_seq', 1, false);
          public          postgres    false    258            5           0    0 *   gastos_preliminares_id_gastopreliminar_seq    SEQUENCE SET     Y   SELECT pg_catalog.setval('public.gastos_preliminares_id_gastopreliminar_seq', 1, false);
          public          postgres    false    255            6           0    0    materiales_id_material_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.materiales_id_material_seq', 1, false);
          public          postgres    false    247            7           0    0    personal_id_personal_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.personal_id_personal_seq', 1, true);
          public          postgres    false    223            8           0    0 '   presupuesto_proyecto_id_presupuesto_seq    SEQUENCE SET     V   SELECT pg_catalog.setval('public.presupuesto_proyecto_id_presupuesto_seq', 1, false);
          public          postgres    false    253            9           0    0    profesion_id_profesion_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.profesion_id_profesion_seq', 2, true);
          public          postgres    false    214            :           0    0    proyecto_id_proyecto_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.proyecto_id_proyecto_seq', 1, false);
          public          postgres    false    236            ;           0    0    tipo_empresa_id_tipoempresa_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.tipo_empresa_id_tipoempresa_seq', 1, true);
          public          postgres    false    218            <           0    0 !   tipo_proyecto_id_tipoproyecto_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.tipo_proyecto_id_tipoproyecto_seq', 3, true);
          public          postgres    false    234            =           0    0    tipo_usuario_id_tipo_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.tipo_usuario_id_tipo_seq', 2, true);
          public          postgres    false    216            >           0    0 !   unidad_medida_id_unidadmedida_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.unidad_medida_id_unidadmedida_seq', 1, false);
          public          postgres    false    245            ?           0    0    usuario_id_usuario_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 2, true);
          public          postgres    false    226            -           2606    24802    asignaciones asignaciones_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.asignaciones
    ADD CONSTRAINT asignaciones_pkey PRIMARY KEY (id_asignacion);
 H   ALTER TABLE ONLY public.asignaciones DROP CONSTRAINT asignaciones_pkey;
       public            postgres    false    233            5           2606    24860 0   asignaciones_proyecto asignaciones_proyecto_pkey 
   CONSTRAINT     {   ALTER TABLE ONLY public.asignaciones_proyecto
    ADD CONSTRAINT asignaciones_proyecto_pkey PRIMARY KEY (id_asignaciones);
 Z   ALTER TABLE ONLY public.asignaciones_proyecto DROP CONSTRAINT asignaciones_proyecto_pkey;
       public            postgres    false    242            +           2606    24786    cliente cliente_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    230            ;           2606    24922 *   compras_materiales compras_materiales_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.compras_materiales
    ADD CONSTRAINT compras_materiales_pkey PRIMARY KEY (id_compra);
 T   ALTER TABLE ONLY public.compras_materiales DROP CONSTRAINT compras_materiales_pkey;
       public            postgres    false    251                       2606    24702    empresa empresa_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (id_empresa);
 >   ALTER TABLE ONLY public.empresa DROP CONSTRAINT empresa_pkey;
       public            postgres    false    221            3           2606    24846    fotografias fotografias_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.fotografias
    ADD CONSTRAINT fotografias_pkey PRIMARY KEY (id_fotografia);
 F   ALTER TABLE ONLY public.fotografias DROP CONSTRAINT fotografias_pkey;
       public            postgres    false    240            C           2606    24998 (   gastos_materiales gastos_materiales_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public.gastos_materiales
    ADD CONSTRAINT gastos_materiales_pkey PRIMARY KEY (id_gastomateriales);
 R   ALTER TABLE ONLY public.gastos_materiales DROP CONSTRAINT gastos_materiales_pkey;
       public            postgres    false    259            A           2606    24979 ,   gastos_preliminares gastos_preliminares_pkey 
   CONSTRAINT     z   ALTER TABLE ONLY public.gastos_preliminares
    ADD CONSTRAINT gastos_preliminares_pkey PRIMARY KEY (id_gastopreliminar);
 V   ALTER TABLE ONLY public.gastos_preliminares DROP CONSTRAINT gastos_preliminares_pkey;
       public            postgres    false    256            9           2606    24902    materiales materiales_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.materiales
    ADD CONSTRAINT materiales_pkey PRIMARY KEY (id_material);
 D   ALTER TABLE ONLY public.materiales DROP CONSTRAINT materiales_pkey;
       public            postgres    false    248            !           2606    24724    personal personal_dui_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.personal
    ADD CONSTRAINT personal_dui_key UNIQUE (dui);
 C   ALTER TABLE ONLY public.personal DROP CONSTRAINT personal_dui_key;
       public            postgres    false    224            #           2606    24720    personal personal_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.personal
    ADD CONSTRAINT personal_pkey PRIMARY KEY (id_personal);
 @   ALTER TABLE ONLY public.personal DROP CONSTRAINT personal_pkey;
       public            postgres    false    224            %           2606    24722    personal personal_telefono_key 
   CONSTRAINT     ]   ALTER TABLE ONLY public.personal
    ADD CONSTRAINT personal_telefono_key UNIQUE (telefono);
 H   ALTER TABLE ONLY public.personal DROP CONSTRAINT personal_telefono_key;
       public            postgres    false    224            =           2606    24957 .   presupuesto_proyecto presupuesto_proyecto_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.presupuesto_proyecto
    ADD CONSTRAINT presupuesto_proyecto_pkey PRIMARY KEY (id_presupuesto);
 X   ALTER TABLE ONLY public.presupuesto_proyecto DROP CONSTRAINT presupuesto_proyecto_pkey;
       public            postgres    false    254            ?           2606    24959 6   presupuesto_proyecto presupuesto_proyecto_proyecto_key 
   CONSTRAINT     u   ALTER TABLE ONLY public.presupuesto_proyecto
    ADD CONSTRAINT presupuesto_proyecto_proyecto_key UNIQUE (proyecto);
 `   ALTER TABLE ONLY public.presupuesto_proyecto DROP CONSTRAINT presupuesto_proyecto_proyecto_key;
       public            postgres    false    254                       2606    24679    profesion profesion_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.profesion
    ADD CONSTRAINT profesion_pkey PRIMARY KEY (id_profesion);
 B   ALTER TABLE ONLY public.profesion DROP CONSTRAINT profesion_pkey;
       public            postgres    false    215            1           2606    24818    proyecto proyecto_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.proyecto
    ADD CONSTRAINT proyecto_pkey PRIMARY KEY (id_proyecto);
 @   ALTER TABLE ONLY public.proyecto DROP CONSTRAINT proyecto_pkey;
       public            postgres    false    237                       2606    24693    tipo_empresa tipo_empresa_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.tipo_empresa
    ADD CONSTRAINT tipo_empresa_pkey PRIMARY KEY (id_tipoempresa);
 H   ALTER TABLE ONLY public.tipo_empresa DROP CONSTRAINT tipo_empresa_pkey;
       public            postgres    false    219            /           2606    24809     tipo_proyecto tipo_proyecto_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public.tipo_proyecto
    ADD CONSTRAINT tipo_proyecto_pkey PRIMARY KEY (id_tipoproyecto);
 J   ALTER TABLE ONLY public.tipo_proyecto DROP CONSTRAINT tipo_proyecto_pkey;
       public            postgres    false    235                       2606    24686    tipo_usuario tipo_usuario_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.tipo_usuario
    ADD CONSTRAINT tipo_usuario_pkey PRIMARY KEY (id_tipo);
 H   ALTER TABLE ONLY public.tipo_usuario DROP CONSTRAINT tipo_usuario_pkey;
       public            postgres    false    217            7           2606    24890     unidad_medida unidad_medida_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public.unidad_medida
    ADD CONSTRAINT unidad_medida_pkey PRIMARY KEY (id_unidadmedida);
 J   ALTER TABLE ONLY public.unidad_medida DROP CONSTRAINT unidad_medida_pkey;
       public            postgres    false    246            '           2606    24763    usuario usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    227            )           2606    24765    usuario usuario_usuario_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_usuario_key UNIQUE (usuario);
 E   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_usuario_key;
       public            postgres    false    227            X           2620    24971     proyecto insert_crearpresupuesto    TRIGGER     �   CREATE TRIGGER insert_crearpresupuesto AFTER INSERT ON public.proyecto FOR EACH ROW EXECUTE FUNCTION public.crearpresupuesto();
 9   DROP TRIGGER insert_crearpresupuesto ON public.proyecto;
       public          postgres    false    237    266            M           2606    24866 ;   asignaciones_proyecto asignaciones_proyecto_asignacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asignaciones_proyecto
    ADD CONSTRAINT asignaciones_proyecto_asignacion_fkey FOREIGN KEY (asignacion) REFERENCES public.asignaciones(id_asignacion);
 e   ALTER TABLE ONLY public.asignaciones_proyecto DROP CONSTRAINT asignaciones_proyecto_asignacion_fkey;
       public          postgres    false    242    3373    233            N           2606    24871 :   asignaciones_proyecto asignaciones_proyecto_encargado_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asignaciones_proyecto
    ADD CONSTRAINT asignaciones_proyecto_encargado_fkey FOREIGN KEY (encargado) REFERENCES public.personal(id_personal);
 d   ALTER TABLE ONLY public.asignaciones_proyecto DROP CONSTRAINT asignaciones_proyecto_encargado_fkey;
       public          postgres    false    224    3363    242            O           2606    24861 9   asignaciones_proyecto asignaciones_proyecto_proyecto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asignaciones_proyecto
    ADD CONSTRAINT asignaciones_proyecto_proyecto_fkey FOREIGN KEY (proyecto) REFERENCES public.proyecto(id_proyecto);
 c   ALTER TABLE ONLY public.asignaciones_proyecto DROP CONSTRAINT asignaciones_proyecto_proyecto_fkey;
       public          postgres    false    242    3377    237            H           2606    24787    cliente cliente_empresa_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_empresa_fkey FOREIGN KEY (empresa) REFERENCES public.empresa(id_empresa);
 F   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_empresa_fkey;
       public          postgres    false    230    221    3359            Q           2606    24933 4   compras_materiales compras_materiales_encargado_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.compras_materiales
    ADD CONSTRAINT compras_materiales_encargado_fkey FOREIGN KEY (encargado) REFERENCES public.usuario(id_usuario);
 ^   ALTER TABLE ONLY public.compras_materiales DROP CONSTRAINT compras_materiales_encargado_fkey;
       public          postgres    false    3367    251    227            R           2606    24923 3   compras_materiales compras_materiales_material_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.compras_materiales
    ADD CONSTRAINT compras_materiales_material_fkey FOREIGN KEY (material) REFERENCES public.materiales(id_material);
 ]   ALTER TABLE ONLY public.compras_materiales DROP CONSTRAINT compras_materiales_material_fkey;
       public          postgres    false    251    3385    248            S           2606    24928 4   compras_materiales compras_materiales_proveedor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.compras_materiales
    ADD CONSTRAINT compras_materiales_proveedor_fkey FOREIGN KEY (proveedor) REFERENCES public.empresa(id_empresa);
 ^   ALTER TABLE ONLY public.compras_materiales DROP CONSTRAINT compras_materiales_proveedor_fkey;
       public          postgres    false    221    3359    251            D           2606    24703    empresa empresa_tipo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_tipo_fkey FOREIGN KEY (tipo) REFERENCES public.tipo_empresa(id_tipoempresa);
 C   ALTER TABLE ONLY public.empresa DROP CONSTRAINT empresa_tipo_fkey;
       public          postgres    false    221    219    3357            L           2606    24847 %   fotografias fotografias_proyecto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.fotografias
    ADD CONSTRAINT fotografias_proyecto_fkey FOREIGN KEY (proyecto) REFERENCES public.proyecto(id_proyecto);
 O   ALTER TABLE ONLY public.fotografias DROP CONSTRAINT fotografias_proyecto_fkey;
       public          postgres    false    240    237    3377            V           2606    25004 1   gastos_materiales gastos_materiales_material_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.gastos_materiales
    ADD CONSTRAINT gastos_materiales_material_fkey FOREIGN KEY (material) REFERENCES public.materiales(id_material);
 [   ALTER TABLE ONLY public.gastos_materiales DROP CONSTRAINT gastos_materiales_material_fkey;
       public          postgres    false    248    3385    259            W           2606    24999 4   gastos_materiales gastos_materiales_presupuesto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.gastos_materiales
    ADD CONSTRAINT gastos_materiales_presupuesto_fkey FOREIGN KEY (presupuesto) REFERENCES public.presupuesto_proyecto(id_presupuesto);
 ^   ALTER TABLE ONLY public.gastos_materiales DROP CONSTRAINT gastos_materiales_presupuesto_fkey;
       public          postgres    false    254    3389    259            U           2606    24980 8   gastos_preliminares gastos_preliminares_presupuesto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.gastos_preliminares
    ADD CONSTRAINT gastos_preliminares_presupuesto_fkey FOREIGN KEY (presupuesto) REFERENCES public.presupuesto_proyecto(id_presupuesto);
 b   ALTER TABLE ONLY public.gastos_preliminares DROP CONSTRAINT gastos_preliminares_presupuesto_fkey;
       public          postgres    false    254    256    3389            P           2606    24903 !   materiales materiales_unidad_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.materiales
    ADD CONSTRAINT materiales_unidad_fkey FOREIGN KEY (unidad) REFERENCES public.unidad_medida(id_unidadmedida);
 K   ALTER TABLE ONLY public.materiales DROP CONSTRAINT materiales_unidad_fkey;
       public          postgres    false    246    248    3383            E           2606    24725     personal personal_profesion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.personal
    ADD CONSTRAINT personal_profesion_fkey FOREIGN KEY (profesion) REFERENCES public.profesion(id_profesion);
 J   ALTER TABLE ONLY public.personal DROP CONSTRAINT personal_profesion_fkey;
       public          postgres    false    3353    215    224            T           2606    24960 7   presupuesto_proyecto presupuesto_proyecto_proyecto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.presupuesto_proyecto
    ADD CONSTRAINT presupuesto_proyecto_proyecto_fkey FOREIGN KEY (proyecto) REFERENCES public.proyecto(id_proyecto);
 a   ALTER TABLE ONLY public.presupuesto_proyecto DROP CONSTRAINT presupuesto_proyecto_proyecto_fkey;
       public          postgres    false    3377    254    237            I           2606    24819    proyecto proyecto_cliente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.proyecto
    ADD CONSTRAINT proyecto_cliente_fkey FOREIGN KEY (cliente) REFERENCES public.cliente(id_cliente);
 H   ALTER TABLE ONLY public.proyecto DROP CONSTRAINT proyecto_cliente_fkey;
       public          postgres    false    3371    230    237            J           2606    24824 !   proyecto proyecto_supervisor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.proyecto
    ADD CONSTRAINT proyecto_supervisor_fkey FOREIGN KEY (supervisor) REFERENCES public.usuario(id_usuario);
 K   ALTER TABLE ONLY public.proyecto DROP CONSTRAINT proyecto_supervisor_fkey;
       public          postgres    false    3367    237    227            K           2606    24829 $   proyecto proyecto_tipo_proyecto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.proyecto
    ADD CONSTRAINT proyecto_tipo_proyecto_fkey FOREIGN KEY (tipo_proyecto) REFERENCES public.tipo_proyecto(id_tipoproyecto);
 N   ALTER TABLE ONLY public.proyecto DROP CONSTRAINT proyecto_tipo_proyecto_fkey;
       public          postgres    false    237    3375    235            F           2606    24766    usuario usuario_tipo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_tipo_fkey FOREIGN KEY (tipo) REFERENCES public.tipo_usuario(id_tipo);
 C   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_tipo_fkey;
       public          postgres    false    3355    227    217            G           2606    24771    usuario usuario_trabajador_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_trabajador_fkey FOREIGN KEY (trabajador) REFERENCES public.personal(id_personal);
 I   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_trabajador_fkey;
       public          postgres    false    224    227    3363                  x�3���O�,.�LN����� .t�      	      x������ � �      �      x������ � �            x������ � �      �      x������ � �            x������ � �            x������ � �            x������ � �            x������ � �      �   :   x�3�t�LM��tN,.)��4�0�5463�40426153׵�4�,�4�30������ ;
�            x������ � �      �   '   x�3��MMN��L��2�t�IM.)�L�,.I����� �p	-            x������ � �      �      x�3�tN,NT�M,)ʬ����� 6q�         1   x�3��O*JTH�,���2�J��OI�IL����2�trs2��=... U�      �   $   x�3���/�2�tL����,.)JL�/����� z�'            x������ � �      �   M   x�3�4�N��⒢����$��$K3�T�4��4c��T�S3s�Ds�DN����|��������\�=... �=�     