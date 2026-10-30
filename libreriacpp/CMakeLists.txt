cmake_minimum_required(VERSION 3.16)

project(LibreriaDNI)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Directorio de salida de los ejecutables
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/bin)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY_DEBUG ${CMAKE_SOURCE_DIR}/bin)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY_RELEASE ${CMAKE_SOURCE_DIR}/bin)

# Crear la librería estática
add_library(dni_utils STATIC
    src/dni_utils.cpp
)

# Directorio de archivos de cabecera
target_include_directories(dni_utils PUBLIC
    ${CMAKE_CURRENT_SOURCE_DIR}/src
)

# Crear el cliente de prueba
add_executable(prueba
    client/prueba.cpp
)

# Enlazar el cliente con la librería
target_link_libraries(prueba PRIVATE dni_utils)