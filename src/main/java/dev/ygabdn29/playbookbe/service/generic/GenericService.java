package dev.ygabdn29.playbookbe.service.generic;

import java.util.List;

public interface GenericService<Entity, Key> {
  public List<Entity> getAll();

  public Entity getById(Key id);

  public Boolean save(Entity entity);

  public Boolean delete(Key id);

}