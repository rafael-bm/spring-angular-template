SHELL := /bin/bash

.ONESHELL:
clear:
	rm -rf ./frontend_dist/templates;    \
	rm -rf ./frontend_dist/static;   \
	mkdir -p ./frontend_dist/templates;  \
	mkdir -p ./frontend_dist/static;

.ONESHELL:
frontend-build: clear
	pushd frontend; \
	ng build --base-href /myappname/ui --deploy-url static/; \
	popd; \
	mv ./frontend/dist/frontend/index.html ./frontend_dist/templates/index.html; \
	mv -v ./frontend/dist/frontend/* ./frontend_dist/static/; \

.ONESHELL:
frontend-build-prod: clear
	pushd frontend; \
	ng build --prod --base-href /myappname/ui --deploy-url static/; \
	popd; \
	mv ./frontend/dist/frontend/index.html ./frontend_dist/templates/index.html; \
	mv -v ./frontend/dist/frontend/* ./frontend_dist/static/; \

.ONESHELL:
wrapper:
	pushd backend; \
	gradle wrapper; \
	popd;

.ONESHELL:
build:
	pushd backend; \
	./gradlew clean build; \
	popd;
