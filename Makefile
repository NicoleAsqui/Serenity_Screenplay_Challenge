
# Comandos de instalación para macOS
install-macos:
	brew install maven
	mvn clean verify

# Comandos para limpiar el entorno
clean:
	rm -rf target
.PHONY: install-windows install-macos install-linux clean
