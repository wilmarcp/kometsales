environments {
    dev {
        flywayProperties {
            url="jdbc:mysql://localhost:3306/clientes"
            user="root"
            password="123456789"
            locations="['filesystem:src/main/resources/db/migration']"
			outOfOrder = true
        }
	}
}