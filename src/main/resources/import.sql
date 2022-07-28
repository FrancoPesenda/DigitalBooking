-- Politicas (título)
INSERT INTO policies (policy) VALUE ('Normas de la casa')
INSERT INTO policies (policy) VALUE ('Salud y seguridad')
INSERT INTO policies (policy) VALUE ('Política de cancelación')

-- Roles
INSERT INTO roles (name) VALUE ("ROLE_CLIENT")
INSERT INTO roles (name) VALUE ("ROLE_ADMIN")

-- Usuarios
INSERT INTO users (email, last_name, name, password, role_id) VALUE ('user', 'user', 'user', '$2a$10$f/kLXh6n0kg7I/ukE9HgMeKnZUWlCz7BS9cBGwuKVFZldpa1hKEZO', 1)
INSERT INTO users (email, last_name, name, password, role_id) VALUE ('root', 'root', 'root', '$2a$10$4vw8365JA.wrjuMCA5n52uZ3Row7jvU1d/2E64u1215lt.wLR1HL2', 2)
INSERT INTO users (email, last_name, name, password, role_id) VALUE ('cristian@gmail.com', 'Donalicio', 'Cristian', '$2a$10$Nfa3TFv0wIMhB3YpG/sXm.sYVCgYC3gbppVckQUfQtzzIy6SLRBkm', 2)
INSERT INTO users (email, last_name, name, password, role_id) VALUE ('francopesenda@gmail.com', 'Pesenda', 'Franco', '$2a$10$eRjlj5qE6Nic/t0AO/HCiu8lYf2LRwidBH9.8.v4PSTc7oUHn0pX2', 2)
INSERT INTO users (email, last_name, name, password, role_id) VALUE ('gabriela@gmail.com', 'Furs', 'Gabriela', '$2a$10$6F2nBp5Rpf6cnkQ41CHHQ.1rG8rffjSfk07oEorALu.k8EUTQsgZG',  2)
INSERT INTO users (email, last_name, name, password, role_id) VALUE ('pamela@gmail.com', 'Gimenez', 'Pamela', '$2a$10$HtU1g.2UMaxNnI9kckLFcOBMsxNHCaCo8uIrvVrdLn5HRiFiGXTb.', 2)
INSERT INTO users (email, last_name, name, password, role_id) VALUE ('paula@gmail.com', 'Lucero', 'Paula', '$2a$10$D6yR6XJxnxfUMJQVaSY80emwohlmbCz3D4k6frhK9iNwhjbywn23O', 2)
INSERT INTO users (email, last_name, name, password, role_id) VALUE ('yam@gmail.com', 'Galindo Echavarria', 'Yam Alexander', '$2a$10$/Z23N9AjQKakosrRt58g9O50XLOc0STTcK/2zhHwN5Ayg4DPlwL5i', 2)

-- Características
INSERT INTO features (feature) VALUE ('wifi')
INSERT INTO features (feature) VALUE ('cocina')
INSERT INTO features (feature) VALUE ('apto mascotas')
INSERT INTO features (feature) VALUE ('pileta')
INSERT INTO features (feature) VALUE ('aire acondicionado')
INSERT INTO features (feature) VALUE ('televisor')
INSERT INTO features (feature) VALUE ('estacionamiento gratuito')
INSERT INTO features (feature) VALUE ('prohibido fumar')
INSERT INTO features (feature) VALUE ('bar')
INSERT INTO features (feature) VALUE ('gimnasio')
INSERT INTO features (feature) VALUE ('hidromasajes')
INSERT INTO features (feature) VALUE ('casino')
INSERT INTO features (feature) VALUE ('playa')
INSERT INTO features (feature) VALUE ('sala de juegos')

-- Categorías
INSERT INTO categories (plural_title, image, singular_title) VALUE ('hoteles', 'https://images.unsplash.com/photo-1611892440504-42a792e24d32?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170', 'Hotel')
INSERT INTO categories (plural_title, image, singular_title) VALUE ('hostels', 'https://images.unsplash.com/photo-1555854877-bab0e564b8d5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1169&q=80', 'Hostel')
INSERT INTO categories (plural_title, image, singular_title) VALUE ('departamentos', 'https://images.unsplash.com/photo-1545324418-cc1a3fa10c00?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=735&q=80', 'Departamento')
INSERT INTO categories (plural_title, image, singular_title) VALUE ('bed and breakfasts', 'https://images.unsplash.com/photo-1540304453527-62f979142a17?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 'Bed and Breakfast')

-- Paises
INSERT INTO countries (country) VALUE ('Argentina')
INSERT INTO countries (country) VALUE ('Colombia')

-- Ciudades
INSERT INTO cities (city_name, country_id) VALUE ('Buenos Aires', 1)
INSERT INTO cities (city_name, country_id) VALUE ('Córdoba', 1)
INSERT INTO cities (city_name, country_id) VALUE ('Paraná', 1)
INSERT INTO cities (city_name, country_id) VALUE ('Corrientes', 1)
INSERT INTO cities (city_name, country_id) VALUE ('Medellín', 2)
INSERT INTO cities (city_name, country_id) VALUE ('Barranquilla', 2)
INSERT INTO cities (city_name, country_id) VALUE ('Bogotá D.C', 2)
INSERT INTO cities (city_name, country_id) VALUE ('Cartagena', 2)

-- Ubicaciones
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Carrera 43G','28-42','6.228225602815489','-75.57085873975491', 5)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Calle 20','44-16','6.224471329684926','-75.5746138321134', 5)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Carlos Calvo','784','-34.61932574450943','-58.37709387671552', 1)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Tucumán','384','-34.600765324801664','-58.37220710964703', 1)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Darregueyra','2050','-34.584147583959485','-58.427841480856834', 1)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Av. Alvear','1891','-34.587214845971886','-58.38906245628078', 1)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Av. Brasil','780','-34.626040716098956','-58.37590286960127', 1)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Guatemala','4636','-34.586629614370274','-58.42411857491671', 1)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Santa Fe','4020','-34.57975074854366','-58.423239051738975', 1)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Avenida Lucio Uranga','3020','-31.71811373557026','-60.50277559413097', 3)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Belgrano','998','-27.471624989090337','-58.83872599066848', 4)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Av. Corrientes','1344','-34.60394199084779','-58.38564735922995', 1)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Carrera 1','12-118','10.41079145181979','-75.55148427138599', 8)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Carrera 44','74-85','10.996115518833655','-74.80941422483322', 6)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Carlos Pellegrini','551','-34.60174307365784','-58.38069063731376', 1)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Av troncal de Occidente','25-94','4.728576162206117','-74.23990844670662', 7)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Av. Fernando Fader','3587','-31.37947658155246','-64.2272550794312', 2)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Calle 32F','66-57','6.238485723612482','-75.58853986131868', 5)
INSERT INTO locations (address,address_number,latitude,longitude,city_id) VALUE ('Carrera 7 Bis','124-36','4.700770314416027','-74.0296040257605', 7)


-- ALOJAMIENTO 1
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('El Selvario 36 Hotel está bien situado en el distrito El Poblado de Medellín.', 'El corazón del país', 'Selvario 36 Hotel', 2, 1)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://images.unsplash.com/photo-1540518614846-7eded433c457?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1157&q=80', 1)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 1)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la cocina', 'https://images.unsplash.com/photo-1600489000022-c2086d79f9d4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=735&q=80', 1)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la sala de estar', 'https://images.unsplash.com/photo-1513694203232-719a280e022f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1169&q=80', 1)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la sala de estar', 'https://images.unsplash.com/photo-1589834390005-5d4fb9bf3d32?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 1)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la sala de estar', 'https://images.unsplash.com/photo-1586023492125-27b2c045efd7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=958&q=80', 1)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 10:00hs', 1, 1)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se permiten fiestas', 1, 1)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No fumar', 1, 1)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus', 2, 1)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Detector de humo', 2, 1)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Depósito de seguridad', 2, 1)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía', 3, 1)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (7, 1, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 1, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 1, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 1, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 1, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 1)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (2, 1)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (3, 1)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (4, 1)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 1)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (8, 1)


-- ALOJAMIENTO 2
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('La Martina Hotel Boutique se encuentra en Medellín, a 1,2 km del parque El Poblado, y ofrece bar, terraza y vistas al jardín. Cuenta con restaurante, recepción 24 horas, servicio de habitaciones y WiFi gratuita en todas las instalaciones. El hotel ofrece habitaciones familiares. Todas las habitaciones incluyen escritorio, TV de pantalla plana, baño privado, ropa de cama y toallas. Algunas habitaciones tienen cocina con horno y fogones. La Martina Hotel Boutique sirve un desayuno americano.', 'La Martina Hotel Boutique', 'La Martina', 1, 2)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://images.unsplash.com/photo-1590073242678-70ee3fc28e8e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1121&q=80', 2)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la cocina', 'https://images.unsplash.com/photo-1556911220-bff31c812dba?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1568&q=80', 2)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 2)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la sala de estar', 'https://images.unsplash.com/photo-1513694203232-719a280e022f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1169&q=80', 2)
INSERT INTO images (title, url, product_id) VALUE ( 'Foto del jardín', 'https://images.unsplash.com/photo-1544727219-d2ff78f0f148?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=627&q=80', 2)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Se pueden alojar niños de cualquier edad', 1, 2)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Los niños a partir de 3 años se considerarán adultos en este alojamiento', 1, 2)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Para ver la información correcta sobre precios y ocupación, añade a la búsqueda el número de niños con los que viajas y sus edades', 1, 2)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No hay edad mínima para el check-in', 2, 2)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía', 3, 2)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (5, 2, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (6, 2, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (6, 2, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (7, 2, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (5, 2, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 2)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 2)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 2)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (3, 2)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (4, 2)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (8, 2)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (14, 2)


-- ALOJAMIENTO 3
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('El Esplendor by Wyndham Buenos Aires Tango goza de una ubicación ideal en Buenos Aires y ofrece habitaciones con aire acondicionado, WiFi gratuita, aparcamiento privado y servicio de habitaciones.', 'Lo clásico de la ciudad', 'Wyndham Tango', 4, 3)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://images.unsplash.com/photo-1574643156929-51fa098b0394?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 3)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la cocina', 'https://images.unsplash.com/photo-1600585152220-90363fe7e115?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 3)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://images.unsplash.com/photo-1604709177225-055f99402ea3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 3)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la sala de estar', 'https://images.unsplash.com/photo-1564078516393-cf04bd966897?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 3)
INSERT INTO images (title, url, product_id) VALUE ('Foto del jardín', 'https://images.unsplash.com/photo-1572085313466-6710de8d7ba3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1935&q=80', 3)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 9:00hs', 1, 3)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-in: 12:00hs', 1, 3)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Depósito del 50% por adelantado', 2, 3)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía', 3, 3)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (5, 3, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (6, 3, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (6, 3, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (7, 3, 4)
INSERT INTO scores ( score, product_id, user_id) VALUE ( 5, 3, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (2, 3)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (4, 3)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 3)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 3)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 3)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (9, 3)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (12, 3)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (14, 3)


-- ALOJAMIENTO 4
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('El Palacio Paz Hotel alberga un bar y ofrece habitaciones en Buenos Aires, a 700 metros de la basílica del Santísimo Sacramento y a 1,5 km del Obelisco de Buenos Aires.', 'La majestuosa obra de arte', 'Palacio Paz Hotel', 2, 4)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://images.unsplash.com/photo-1595526114035-0d45ed16cfbf?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 4)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la cocina', 'https://images.unsplash.com/photo-1600489000022-c2086d79f9d4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=735&q=80', 4)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://images.unsplash.com/photo-1604014237256-11d475e2a2d8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 4)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la sala de estar', 'https://images.unsplash.com/photo-1586023492125-27b2c045efd7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=958&q=80', 4)
INSERT INTO images (title, url, product_id) VALUE ('Foto del jardín', 'https://images.unsplash.com/photo-1580600301354-0ce8faef576c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=688&q=80', 4)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 9:00hs', 1, 4)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-in: 12:00hs', 1, 4)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Depósito del 50% por adelantado', 2, 4)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía', 3, 4)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (2, 4, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (5, 4, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (4, 4, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (1, 4, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (2, 4, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (3, 4)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 4)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 4)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 4)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 4)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (10, 4)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (11, 4)


-- ALOJAMIENTO 5
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('El Departamento en Palermo Soho se encuentra en Buenos Aires, a 1,4 km de la plaza Serrano y a 2 km del parque ecológico de Buenos Aires, y ofrece alojamiento con WiFi gratuita, aire acondicionado.', 'En la cúspide de lo grande', 'Palermo Soho', 3, 5)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://images.unsplash.com/photo-1566665797739-1674de7a421a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80', 5)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la cocina', 'https://images.unsplash.com/photo-1588854337236-6889d631faa8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 5)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://images.unsplash.com/photo-1564540583246-934409427776?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1153&q=80', 5)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la sala de estar', 'https://images.unsplash.com/photo-1589834390005-5d4fb9bf3d32?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 5)
INSERT INTO images (title, url, product_id) VALUE ('Foto del jardín', 'https://images.unsplash.com/photo-1585320806297-9794b3e4eeae?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1632&q=80', 5)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 9:00hs', 1, 5)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-in: 12:00hs', 1, 5)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Depósito del 50% por adelantado', 2, 5)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía', 3, 5)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (2, 5, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (5, 5, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (4, 5, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (1, 5, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (2, 5, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 5)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (2, 5)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 5)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 5)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 5)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (9, 5)


-- ALOJAMIENTO 6
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('El Recoleta Plaza Guido se encuentra en Buenos Aires, a solo 100 metros del cementerio de la Recoleta, y ofrece alojamiento con acceso a una piscina al aire libre y recepción 24 horas.', 'Ayres Recoleta Plaza', 'Ayres', 4, 6)

---- Imagenes del alojamiento
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto de la habitación', 'https://images.unsplash.com/photo-1615874959474-d609969a20ed?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', 6)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto de la cocina', 'https://images.unsplash.com/photo-1588854337221-4cf9fa96059c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 6)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto del baño', 'https://images.unsplash.com/photo-1600566752355-35792bedcfea?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 6)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto de la sala de estar', 'https://images.unsplash.com/photo-1598928506311-c55ded91a20c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 6)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto del jardín', 'https://images.unsplash.com/photo-1571192776145-9f563c1df686?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=735&q=80', 6)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 9:00hs', 1, 6)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-in: 12:00hs', 1, 6)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Depósito del 50% por adelantado', 2, 6)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía', 3, 6)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (8, 6, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 6, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (10, 6, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (10, 6, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 6, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 6)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 6)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 6)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (9, 6)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (8, 6)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (14, 6)


-- ALOJAMIENTO 7
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('El Merit San Telmo ofrece alojamiento en el moderno barrio de San Telmo, una ubicación céntrica en Buenos Aires. Hay conexión Wi-Fi gratuita en todas las instalaciones.', 'Clásico y lujoso', 'Mérit San Telmo', 4, 7)

---- Imagenes del alojamiento
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto de la habitación', 'https://images.unsplash.com/flagged/photo-1573168710865-2e4c680d921a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 7)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto de la cocina', 'https://images.unsplash.com/photo-1556912173-3bb406ef7e77?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 7)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto del baño', 'https://images.unsplash.com/photo-1620626011761-996317b8d101?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1169&q=80', 7)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto de la sala de estar', 'https://images.unsplash.com/photo-1481277542470-605612bd2d61?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1106&q=80', 7)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto del jardín', 'https://images.unsplash.com/photo-1463554050456-f2ed7d3fec09?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 7)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 9:00hs', 1, 7)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-in: 12:00hs', 1, 7)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Depósito del 50% por adelantado', 2, 7)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía', 3, 7)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (8, 7, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 7, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (10, 7, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (10, 7, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 7, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 7)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 7)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 7)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 7)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (9, 7)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (12, 7)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (14, 7)


-- ALOJAMIENTO 8
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('El Byblos Palermo Soho está situado en el exclusivo barrio de Palermo Soho de Buenos Aires y ofrece alojamientos totalmente equipados. La plaza Serrano se encuentra a 400 metros.', 'Ubicado en el centro de la ciudad', 'Byblos Palermo Soho', 1, 8)

---- Imagenes del alojamiento
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto de la habitación', 'https://images.unsplash.com/photo-1598928636135-d146006ff4be?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 8)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto de la cocina', 'https://images.unsplash.com/photo-1484154218962-a197022b5858?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1174&q=80', 8)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto del baño', 'https://images.unsplash.com/photo-1576698483491-8c43f0862543?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=648&q=80', 8)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto de la sala de estar', 'https://images.unsplash.com/photo-1486304873000-235643847519?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1632&q=80', 8)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto del jardín', 'https://images.unsplash.com/photo-1547389432-95b8f3c47f3c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=685&q=80', 8)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 9:00hs', 1, 8)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-in: 12:00hs', 1, 8)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Depósito del 50% por adelantado', 2, 8)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía', 3, 8)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (8, 8, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 8, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (10, 8, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (10, 8, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 8, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (4, 8)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 8)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 8)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 8)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (9, 8)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (10, 8)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (11, 8)


-- ALOJAMIENTO 9
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('El Dream Studios BA está situado a 1 calle de la Avenida Santa Fe y cuenta con piscina al aire libre, solárium, terraza y zona de barbacoa.', 'Para descansar con tranquilidad', 'Dream Studios BA', 3, 9)

---- Imagenes del alojamiento
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto de la habitación', 'https://images.unsplash.com/photo-1560185893-a55cbc8c57e8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 9)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto de la cocina', 'https://images.unsplash.com/photo-1556037843-347ddff9f4b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 9)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto del baño', 'https://images.unsplash.com/photo-1603825491103-bd638b1873b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=688&q=80', 9)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto de la sala de estar', 'https://images.unsplash.com/photo-1486946255434-2466348c2166?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 9)
INSERT INTO images (id, title, url, product_id) VALUE (null, 'Foto del jardín', 'https://images.unsplash.com/photo-1559749284-7a6971fd798e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 9)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 9:00hs', 1, 9)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-in: 12:00hs', 1, 9)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Depósito del 50% por adelantado', 2, 9)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía', 3, 9)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (7, 9, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (7, 9, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (6, 9, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 9, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 9, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 9)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (2, 9)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (3, 9)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 9)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 9)


-- ALOJAMIENTO 10
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('Vieja casona ambientada en un estilo moderno y conservando toda la escencia de los recuerdos, para que te sientas en tu hogar.', 'Moderna y acogedora', 'Vieja Casona', 3, 10)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://images.freeimages.com/images/large-previews/13c/hotelroom-1255076.jpg', 10)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2012/08/19/22/58/bathtub-54587_960_720.jpg', 10)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la cocina', 'https://cdn.pixabay.com/photo/2016/10/20/20/52/kitchen-1756631_960_720.jpg', 10)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la sala de estar y habitación', 'https://cdn.pixabay.com/photo/2014/11/11/22/54/bedroom-527645_960_720.jpg', 10)
INSERT INTO images (title, url, product_id) VALUE ('Foto del desayuno', 'https://cdn.pixabay.com/photo/2015/08/20/20/07/cereal-898073_960_720.jpg', 10)
INSERT INTO images (title, url, product_id) VALUE ('Foto del jardín', 'https://cdn.pixabay.com/photo/2012/03/03/22/59/clean-21479_960_720.jpg', 10)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 10:00hs', 1, 10)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se permiten fiestas', 1, 10)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se permiten mascotas', 1, 10)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Alarma de incendio', 2, 10)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Detector de humo', 2, 10)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('La cancelación de la reserva es hasta 48hs antes del ingreso para recibir reintegro', 3, 10)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Sólo se realizan reintegros del 50% del valor pagado', 3, 10)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (9, 10, 6)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 10, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 10, 5)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 10, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 10, 3)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 10)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (2, 10)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 10)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 10)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 10)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (9, 10)


-- ALOJAMIENTO 11
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('El Hostel más pintoresco de la ciudad, para disfrutar de los amigos y del paisaje cerca del centro de la ciudad.', 'Pintoresco y bien ubicado', 'Hostel Las Luces', 2, 11)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto del jardín', 'https://cdn.pixabay.com/photo/2014/08/10/09/52/house-414618_960_720.jpg', 11)
INSERT INTO images (title, url, product_id) VALUE ('Foto del comedor', 'https://cdn.pixabay.com/photo/2017/05/14/16/25/restaurant-2312430_960_720.jpg', 11)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://cdn.pixabay.com/photo/2019/08/19/13/58/bed-4416515_960_720.jpg', 11)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2019/04/15/18/13/bathroom-4130000_960_720.jpg', 11)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la sala de estar', 'https://cdn.pixabay.com/photo/2017/12/27/14/42/furniture-3042835_960_720.jpg', 11)
INSERT INTO images (title, url, product_id) VALUE ('Foto del desayuno', 'https://cdn.pixabay.com/photo/2015/07/17/00/52/breakfast-848313_960_720.jpg', 11)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la pileta', 'https://images.freeimages.com/images/large-previews/ba8/hotel-pool-1470899.jpg', 11)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 11:00hs', 1, 11)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Espacio libre de humo', 1, 11)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Accesible para personas con movilidad reducida', 2, 11)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Alarma de incendio', 2, 11)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Depósito de seguridad', 2, 11)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se reintegra el dinero en caso de cancelar la reserva', 3, 11)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (7, 11, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 11, 6)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 11, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (7, 11, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 11, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 11)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (2, 11)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (4, 11)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 11)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (8, 11)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (11, 11)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (10, 11)


-- ALOJAMIENTO 12
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('Departamento moderno, amplio, con dos dormitorios y completamente equipado, ubicado en el centro de la ciudad.', 'Cómodo, moderno y con una excelente ubicación', 'Departamento céntrico', 3, 12)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://cdn.pixabay.com/photo/2016/04/15/11/45/hotel-1330841_960_720.jpg', 12)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://cdn.pixabay.com/photo/2016/03/28/09/34/bedroom-1285156_960_720.jpg', 12)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2017/02/24/12/23/bathroom-2094716_960_720.jpg', 12)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2017/02/24/12/21/bathroom-2094684_960_720.jpg', 12)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la cocina', 'https://cdn.pixabay.com/photo/2016/07/26/18/27/kitchen-1543487_960_720.jpg', 12)
INSERT INTO images (title, url, product_id) VALUE ('Foto del desayuno', 'https://cdn.pixabay.com/photo/2016/05/17/14/52/breakfast-1398259_960_720.jpg', 12)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-in: 14:00hs', 1, 12)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 10:00hs', 1, 12)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No fumar', 1, 12)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se permiten mascotas', 1, 12)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Caja de seguridad', 2, 12)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Alarma de incendio', 2, 12)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía', 3, 12)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (9, 12, 5)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 12, 6)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 12, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 12, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 12, 2)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 12)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (2, 12)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 12)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 12)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (8, 12)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (9, 12)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (12, 12)


-- ALOJAMIENTO 13
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('Square Hotel está ubicado en la mejor zona de la costa colombiana, a orillas del mar.', 'El corazón del país', 'Square Hotel', 1, 13)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://cdn.pixabay.com/photo/2017/01/14/12/48/hotel-1979406_960_720.jpg', 13)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2017/02/07/18/24/bathroom-2046702_960_720.jpg', 13)
INSERT INTO images (title, url, product_id) VALUE ('Foto del jardín', 'https://images.freeimages.com/images/large-previews/6dd/hotel-lawn-1526755.jpg', 13)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la pileta', 'https://images.freeimages.com/images/large-previews/9d3/hotel-1217956.jpg', 13)
INSERT INTO images (title, url, product_id) VALUE ('Foto del desayuno', 'https://cdn.pixabay.com/photo/2016/12/20/21/37/breakfast-hotel-1921530_960_720.jpg', 13)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la playa', 'https://images.freeimages.com/images/large-previews/e14/don-cesar-hotel-1483881.jpg', 13)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 10:30hs', 1, 13)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se permiten mascotas', 1, 13)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Espacio libre de humo', 1, 13)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Se aplican las pautas de distanciamiento social por coronavirus en zonas comunes', 2, 13)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Depósito de seguridad', 2, 13)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('La cancelación de la reserva debe realizarse hasta 24hs antes del ingreso', 3, 13)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (9, 13, 6)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 13, 5)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 13, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 13, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 13, 2)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 13)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (4, 13)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 13)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 13)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 13)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (10, 13)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (11, 13)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (13, 13)


-- ALOJAMIENTO 14
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('En el corazón de la costa colomiana y rodeado de la naturaleza, Estelar Bed & Breakfast es la mejor opción para un descanso asegurado.', 'Naturaleza y confort', 'Estelar Bed & Breakfast', 4, 14)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://cdn.pixabay.com/photo/2021/08/27/01/33/bedroom-6577523_960_720.jpg', 14)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2018/01/11/22/11/room-3077080_960_720.jpg', 14)
INSERT INTO images (title, url, product_id) VALUE ('Foto del comedor', 'https://cdn.pixabay.com/photo/2015/04/06/20/35/table-710040_960_720.jpg', 14)
INSERT INTO images (title, url, product_id) VALUE ('Foto del desayuno', 'https://cdn.pixabay.com/photo/2016/03/02/16/42/breakfast-1232620_960_720.jpg', 14)
INSERT INTO images (title, url, product_id) VALUE ('Foto del jardín', 'https://cdn.pixabay.com/photo/2015/06/12/12/10/castle-park-806854_960_720.jpg', 14)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la pileta', 'https://images.freeimages.com/images/large-previews/2df/hotel-1500509.jpg', 14)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 11:00hs', 1, 14)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Se permiten mascotas', 1, 14)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No fumar', 1, 14)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Alarma de incendio', 2, 14)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Caja de seguridad privada', 2, 14)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Vigilancia las 24 horas', 2, 14)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Los detalles de la cancelación se coordinan luego de confirmar la reserva', 3, 14)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (7, 14, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (7, 14, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 14, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (7, 14, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 14, 6)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 14)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (3, 14)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (4, 14)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 14)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (8, 14)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (9, 14)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (14, 14)


-- ALOJAMIENTO 15
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('Modern Apartament está ubicado en el centro de la Ciudad de Buenos Aires, cerca de los mejores lugares para conocer.', 'Cerca de todo', 'Modern Apartament', 3, 15)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la cocina comedor', 'https://cdn.pixabay.com/photo/2017/02/24/12/19/apartment-2094666_960_720.jpg', 15)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la cocina', 'https://cdn.pixabay.com/photo/2017/02/24/12/22/apartment-2094700_960_720.jpg', 15)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la cocina comedor', 'https://cdn.pixabay.com/photo/2017/02/24/12/19/apartment-2094661_960_720.jpg', 15)
INSERT INTO images (title, url, product_id) VALUE ('Foto del comedor', 'https://cdn.pixabay.com/photo/2017/02/24/12/22/apartment-2094699_960_720.jpg', 15)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2016/08/26/15/06/bathroom-1622403_960_720.jpg', 15)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://images.freeimages.com/images/large-previews/b6b/hotel-room-1217627.jpg', 15)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://cdn.pixabay.com/photo/2015/05/09/17/09/towel-759980_960_720.jpg', 15)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 10:30hs', 1, 15)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se permiten fiestas', 1, 15)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Espacio libre de humo', 1, 15)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se permiten mascotas', 1, 15)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Seguridad las 24hs', 2, 15)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Caja de seguridad', 2, 15)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Cancelación de la reserva hasta 48hs antes del ingreso', 3, 15)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (9, 15, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 15, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 15, 6)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 15, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 15, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 15)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (2, 15)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 15)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 15)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (8, 15)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (14, 15)


-- ALOJAMIENTO 16
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('Hotel Palace 365 está ubicado en el centro de la ciudad de Bogotá. Cálido, lujoso y elegante.', 'En el corazón de la ciudad', 'Hotel Palace 365', 1, 16)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://cdn.pixabay.com/photo/2016/06/10/01/05/hotel-room-1447201_960_720.jpg', 16)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2014/10/16/08/41/bathroom-490781_960_720.jpg', 16)
INSERT INTO images (title, url, product_id) VALUE ('Foto del comedor', 'https://images.freeimages.com/images/large-previews/d9a/breakfast-grand-hotel-1527177.jpg', 16)
INSERT INTO images (title, url, product_id) VALUE ('Foto del comedor', 'https://cdn.pixabay.com/photo/2015/09/21/09/53/villa-cortine-palace-949547_960_720.jpg', 16)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://cdn.pixabay.com/photo/2020/10/18/09/16/bedroom-5664221_960_720.jpg', 16)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2016/04/18/08/51/bathroom-1336164_960_720.jpg', 16)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 10:00hs', 1, 16)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se permiten mascotas', 1, 16)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Espacio libre de humo', 1, 16)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus', 2, 16)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Seguridad las 24 horas', 2, 16)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Depósito de seguridad', 2, 16)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Cancelación de la reserva a coordinar al momento de realizar el pago', 3, 16)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (7, 16, 6)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 16, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 16, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 16, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 16, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 16)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 16)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 16)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 16)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (8, 16)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (4, 16)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (12, 16)


-- ALOJAMIENTO 17
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('Con una conveniente ubicación en Córdoba, Gala Hotel ofrece unas vacaciones inolvidables en las afueras, a 20 minutos del centro de la ciudad en auto.', 'Vacaciones inolvidables en la Ciudad de Córdoba', 'Gala Hotel', 1, 17)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://cdn.pixabay.com/photo/2016/11/19/13/06/bed-1839183_960_720.jpg', 17)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la pileta', 'https://cdn.pixabay.com/photo/2016/11/18/17/41/summer-1836046_960_720.jpg', 17)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2016/05/26/04/17/double-sink-1416377_960_720.jpg', 17)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la sala de estar', 'https://cdn.pixabay.com/photo/2018/08/06/19/49/design-3588214_960_720.jpg', 17)
INSERT INTO images (title, url, product_id) VALUE ('Foto del desayuno', 'https://cdn.pixabay.com/photo/2016/11/29/05/07/breads-1867459_960_720.jpg', 17)
INSERT INTO images (title, url, product_id) VALUE ('Foto del comedor', 'https://cdn.pixabay.com/photo/2018/01/15/17/32/table-3084384_960_720.jpg', 17)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 11:00hs', 1, 17)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se permiten mascotas', 1, 17)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se permite fumar', 1, 17)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Distanciamiento social en áreas comunes por coronavirus', 2, 17)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Accesible para personas con movilidad reducida', 2, 17)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Alarma de incendio', 2, 17)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('La cancelación de la reserva se debe informar con 72hs de anticipación', 3, 17)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (7, 17, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (7, 17, 3)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 17, 5)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 17, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 17, 4)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 17)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 17)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 17)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (7, 17)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (8, 17)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (10, 17)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (11, 17)


-- ALOJAMIENTO 18
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('La Alondra Casa de Huéspedes es un confortable departamento en Medellín. Equipado para pasar unas excelentes vacaciones y disfrutar de la naturaleza.', 'Confortable y bien equipado', 'La Alondra Casa de Huéspedes', 3, 18)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://cdn.pixabay.com/photo/2020/11/24/11/36/bedroom-5772286_960_720.jpg', 18)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2017/02/24/12/24/bathroom-2094735_960_720.jpg', 18)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2017/02/24/12/24/bathroom-2094733_960_720.jpg', 18)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la cocina', 'https://cdn.pixabay.com/photo/2017/02/24/12/22/kitchen-2094707_960_720.jpg', 18)
INSERT INTO images (title, url, product_id) VALUE ('Foto del jardín', 'https://cdn.pixabay.com/photo/2017/06/27/07/51/sunbeds-2446568_960_720.jpg', 18)
INSERT INTO images (title, url, product_id) VALUE ('Foto del desayuno', 'https://cdn.pixabay.com/photo/2016/11/18/15/53/breakfast-1835478_960_720.jpg', 18)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 10:00hs', 1, 18)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se permiten fiestas', 1, 18)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No fumar', 1, 18)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Desinfección de áreas comunes por coronavirus', 2, 18)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Alcohol en gel en áreas comunes por coronavirus', 2, 18)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Caja de seguridad', 2, 18)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía', 3, 18)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (7, 18, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 18, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 18, 6)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 18, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 18, 3)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 18)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (2, 18)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (3, 18)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (8, 18)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (10, 18)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (14, 18)


-- ALOJAMIENTO 19
---- Alojamiento
INSERT INTO products (description, description_title, name, category_id, location_id) VALUE ('Santa Bárbara B&B está ubicada en plena Ciudad de Bogotá. Cómodo y amueblado, para unas vacaciones ideales.', 'Vacaciones en Bogotá', 'Santa Bárbara B&B', 4, 19)

---- Imagenes del alojamiento
INSERT INTO images (title, url, product_id) VALUE ('Foto de la habitación', 'https://cdn.pixabay.com/photo/2021/11/08/00/30/bedroom-6778193_960_720.jpg', 19)
INSERT INTO images (title, url, product_id) VALUE ('Foto del baño', 'https://cdn.pixabay.com/photo/2016/04/18/08/51/bathroom-1336165_960_720.jpg', 19)
INSERT INTO images (title, url, product_id) VALUE ('Foto del desayuno', 'https://cdn.pixabay.com/photo/2018/02/07/14/11/food-3137152_960_720.jpg', 19)
INSERT INTO images (title, url, product_id) VALUE ('Foto del desayuno', 'https://cdn.pixabay.com/photo/2016/08/09/22/39/breakfast-1582032_960_720.jpg', 19)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la pileta', 'https://cdn.pixabay.com/photo/2020/03/21/20/04/real-estate-4955093_960_720.jpg', 19)
INSERT INTO images (title, url, product_id) VALUE ('Foto de la pileta', 'https://cdn.pixabay.com/photo/2019/10/17/02/39/villa-4555818_960_720.jpg', 19)

---- Políticas (descripción)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Check-out: 09:30hs', 1, 19)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('No se permiten mascotas', 1, 19)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Espacio libre de humo', 1, 19)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Se aplican las pautas de distanciamiento social en áreas comunes por coronavirus', 2, 19)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Alarma de incendio', 2, 19)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Caja de seguridad', 2, 19)
INSERT INTO policies_products (description, policy_id, product_id) VALUE ('Cancelación de reservas hasta 24hs antes del ingreso.', 3, 19)

---- Puntuaciones
INSERT INTO scores (score, product_id, user_id) VALUE (7, 19, 2)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 19, 6)
INSERT INTO scores (score, product_id, user_id) VALUE (9, 19, 1)
INSERT INTO scores (score, product_id, user_id) VALUE (8, 19, 4)
INSERT INTO scores (score, product_id, user_id) VALUE (7, 19, 5)

---- Características del alojamiento
INSERT INTO featuresproducts (feature_id, product_id) VALUE (1, 19)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (4, 19)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (5, 19)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (6, 19)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (8, 19)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (9, 19)
INSERT INTO featuresproducts (feature_id, product_id) VALUE (14, 19)

--- Reservas
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2022-02-15', '2022-01-15', '13:30', 1, 3);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2020-09-10', '2020-09-01', '13:30', 2, 4);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2021-10-03', '2021-09-12', '11:30', 2, 7);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2022-02-20', '2022-02-04', '13:00', 3, 8);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2022-03-28', '2022-03-18', '11:30', 3, 5);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2022-12-15', '2022-12-04', '12:00', 3, 5);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2021-07-15', '2021-07-12', '12:00', 4, 6);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2022-02-07', '2022-01-26', '16:30', 7, 7);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2021-11-16', '2021-11-10', '11:00', 10, 3);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2022-03-18', '2022-03-12', '11:00', 11, 6);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2022-07-30', '2022-07-19', '16:30', 11, 6);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2022-10-25', '2022-10-22', '13:30', 13, 4);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2020-10-10', '2020-09-25', '13:00', 16, 8);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2022-12-15', '2022-12-04', '12:00', 3, 5);
INSERT INTO reservations (finish_day, start_day, start_time, product_id, user_id) VALUE ('2021-07-15', '2021-07-12', '12:00', 4, 6);

-- Favoritos

INSERT INTO favorites (product_id,user_id) VALUE (1,1);
INSERT INTO favorites (product_id,user_id) VALUE (1,3);
INSERT INTO favorites (product_id,user_id) VALUE (1,4);
INSERT INTO favorites (product_id,user_id) VALUE (1,10);
INSERT INTO favorites (product_id,user_id) VALUE (2,12);
INSERT INTO favorites (product_id,user_id) VALUE (2,1);
INSERT INTO favorites (product_id,user_id) VALUE (2,3);
INSERT INTO favorites (product_id,user_id) VALUE (3,3);
INSERT INTO favorites (product_id,user_id) VALUE (3,1);
