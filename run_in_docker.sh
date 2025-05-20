#!/bin/bash

IMAGE_PLAYWRIGHT="em24-playwright"
IMAGE_TESTS="em24-tests"

# Check if the base Playwright image exists
if [[ "$(docker images -q $IMAGE_PLAYWRIGHT 2> /dev/null)" == "" ]]; then
  echo "Image $IMAGE_PLAYWRIGHT not found. Building it now..."
  docker build -t $IMAGE_PLAYWRIGHT -f Dockerfile.playwright .
else
  echo "Image $IMAGE_PLAYWRIGHT already exists. Skipping build."
fi

# Build the test image
docker build -t $IMAGE_TESTS -f Dockerfile.tests .


# Run the container
docker run --rm \
  -e BASE_URL="$BASE_URL" \
  -e TEST_USER_NAME="$TEST_USER_NAME" \
  -e TEST_USER_PASSWORD="$TEST_USER_PASSWORD" \
  $IMAGE_TESTS