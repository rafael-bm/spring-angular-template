SHELL := /bin/bash

.ONESHELL:
clear:
	rm -rf ./frontend_dist/templates;    \
	rm -rf ./frontend_dist/static;   \
	mkdir -p ./frontend_dist/templates;  \
	mkdir -p ./frontend_dist/static;

.ONESHELL:
frontend-build-prod: clear
	pushd frontend; \
	ng build --prod --base-href /myappname/ui --deploy-url static/; \
	popd; \
	mv ./frontend/dist/frontend/index.html ./frontend_dist/templates/index.html; \
	mv -v ./frontend/dist/frontend/* ./frontend_dist/static/; \

.ONESHELL:
frontend-run:
	pushd frontend; \
	ng serve; \
	popd; \

.ONESHELL:
backend-stub-wrapper:
	pushd backend_stub; \
	gradle wrapper; \
	popd; \

.ONESHELL:
backend-stub-run:
	pushd backend_stub; \
	./gradlew run; \
	popd; \

.ONESHELL:
service-run:
	pushd backend; \
	./gradlew bootRun; \
	popd; \

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
