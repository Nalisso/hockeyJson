
SHELL = bash

.go-dock: go-dock/Dockerfile Makefile
	docker build -t go-dock go-dock
	touch .go-dock

test-json: test-json.go .go-dock
	docker run -v $$(pwd):/go/src/app go-dock go run test-json.go
