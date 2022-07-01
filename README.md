# BazarSpringBoot
CRUD using SpringBoot - JPA:Hibernate.

Postman Import: https://www.getpostman.com/collections/1ebff9b16de18f307bde



                                                        Atributos extras en las clases Producto y Cliente:

Boolean borrado;
String descripcion_estado;


                                                        Funcionamiento de los endpoints de Eliminación:

El endpoint para eliminar una venta, utliza el método del repository "delete", mientras que tanto el endpoint de eliminación
de producto y de cliente, realiza un borrado lógico, cambiando su atributo "borrado" a "true" y su atributo "descripcion_estado".
El mismo se actualiza dependiendo del estado del atributo "borrado", si éste es "true", contendrá el texto
"Producto eliminado" o "Cliente inactivo/eliminado" según corresponda. 
En el caso de ser "false", contendrá el texto "Producto existente" o "Cliente activo".

La finalidad de estos atributos, es que a la hora de eliminar  un producto o cliente, las ventas que contengan dichos objetos sigan permaneciendo en la Base de Datos, pero indicando mediante "descripcion_estado" que ya no se encuentran activos o existentes.



                                                                    Endpoints Extras:

Producto  :
           "/listar-borrados"               Este endpoint se utliza para listar solamente los productos o clientes que se eliminaron utilizando borrado lógico.
Cliente   :                                 



Venta:  "/agregar-producto"             Este endpoint tiene la funcionalidad de añadir un objeto del tipo producto, 
                                        a la lista de una venta (la cual es obtenida mediante su codigo).




                                                                Datos a tener en cuenta:

El atributo "total" correspondiente a cada Venta, se calcula automáticamente luego de ejecutar el endpoint "/venta/crear". Dicho cálculo se realiza recorriendo
la lista de productos almacenada en la venta y sumando los costos de cada producto. (Se realiza el mismo cálculo a la hora de editar la lista o agregar un producto).

En los endpoints "/listar" de la clase Producto y Cliente, solamente mostrará los que no fueron eliminados mediante borrado Lógico, es decir los que tienen el atributo "borrado", en estado "false".
                            
                            