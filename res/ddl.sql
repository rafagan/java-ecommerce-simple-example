create table item_
(
  descricao varchar(255) null,
  detalhes varchar(255) null,
  nome varchar(255) null,
  id int auto_increment primary key
);

create table usuario
(
  codigoSeguranca int null,
  dataValidade varchar(255) null,
  login varchar(255) null,
  numeroCartao varchar(255) null,
  senha varchar(255) null,
  id int auto_increment primary key,
  constraint usuario_login_uindex
    unique (login)
);

create table pedidocompra
(
  data date null,
  id int auto_increment primary key,
  usuarioId int not null,
  constraint pedidocompra_usuario_id_fk
    foreign key (usuarioId) references usuario (id)
    on delete cascade
);

create index pedidocompra_usuario_id_fk
  on pedidocompra (usuarioId);

create table itempedido
(
  quantidade int null,
  id int auto_increment
    primary key,
  pedidoCompraId int null,
  itemID int not null,
  constraint itempedido_pedidocompra_id_fk
    foreign key (pedidoCompraId) references pedidocompra (id)
    on delete cascade,
  constraint itempedido_item__id_fk
    foreign key (itemID) references item_ (id)
);

create index itempedido_item__id_fk
  on itempedido (itemID);

create index itempedido_pedidocompra_id_fk
  on itempedido (pedidoCompraId);