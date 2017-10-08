# Install - OSX
# brew install mysql;
# mysql  Ver 14.14 Distrib 5.7.13, for osx10.11 (x86_64) using  EditLine wrapper

# Stop My SQl - OSX
# brew services stop mysql

# Start My SQL - OSX
# brew services start mysql

# Remove mysql
# brew remove mysql
# brew cleanup

#Recover password
#$ mysqld --skip-grant-tables
# $ mysql -u root mysql
# $mysql> UPDATE user SET Password=PASSWORD('my_password') where USER='root';
# $mysql> FLUSH PRIVILEGES;

# Vertical display in mysql terminal
# select * from user \G

# Data Definition Language - SQL

# Drop tables
# drop table river;
# drop table state;
# drop table country;

#-- Create DB
#create database rivers;

# Table Country
CREATE
	TABLE
		country(
			id INT(10) NOT NULL PRIMARY key auto_increment,
			name VARCHAR(50) NOT NULL,
			area_km2 DECIMAL(
				20,
				8
			) NOT NULL,
			population BIGINT NOT NULL,
			country_code VARCHAR(2) NOT NULL
		);
desc country;

# Table State
CREATE
	TABLE
		state(
			id INT(10) NOT NULL PRIMARY key auto_increment,
			name VARCHAR(50) NOT NULL,
			area_km2 DECIMAL(
				20,
				8
			) NOT NULL,
			population BIGINT NOT NULL,
			LANGUAGE VARCHAR(50),
			country_id INT NOT NULL,
			FOREIGN KEY(country_id) REFERENCES rivers.country(id)
		);
desc state;

# Table River
create
	table
		river(
			id int(10) not null primary key auto_increment,
			name varchar(50) not null,
			origin varchar(50),
			length_km int(10) not null,
			basin_km2 bigint not null,
			state_id int not null,
			main_river_id int,
			FOREIGN KEY(state_id) REFERENCES rivers.state(id),
			FOREIGN KEY(main_river_id) REFERENCES rivers.river(id)
		);
desc river;

# Add Country
INSERT
	INTO
		country(
			name,
			area_km2,
			population,
			country_code
		)
	VALUES(
		'India',
		3287000,
		1342512706,
		'IN'
	);

# Add State
INSERT
	INTO
		state(
			name,
			area_km2,
			population,
			language,
			country_id
		)
	VALUES(
		'Karnataka',
		191791,
		65866188,
		'Kannada',
		'1'
	);

# Add Rivers
INSERT
	INTO
		river(
			name,
			origin,
			length_km,
			basin_km2,
			state_id
		)
	VALUES(
		'Kaveri',
		'Tala Kaveri',
		765,
		81155,
		1
	);

# Add Tributaries
INSERT
	INTO
		river(
			name,
			origin,
			length_km,
			basin_km2,
			state_id,
			main_river_id
		)
	VALUES(
		'Hemavati',
		'Ballala rayana durga, Ckmlr',
		245,
		5410,
		1,
		1
	);
