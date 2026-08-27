package dev.ygabdn29.playbookbe.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ygabdn29.playbookbe.entity.User;

interface UserRepository extends JpaRepository<User, UUID> {

}