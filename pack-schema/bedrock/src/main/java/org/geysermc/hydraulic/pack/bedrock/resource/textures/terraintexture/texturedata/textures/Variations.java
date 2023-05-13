package org.geysermc.hydraulic.pack.bedrock.resource.textures.terraintexture.texturedata.textures;

import java.lang.String;

/**
 * Variantion
 * <p>
 * One of the variantions, specified along with a possible weight.
 */
public class Variations {
  public String path;

  public int weight;

  /**
   * A texture file.
   *
   * @return Path
   */
  public String getPath() {
    return this.path;
  }

  /**
   * A texture file.
   *
   * @param path Path
   */
  public void setPath(String path) {
    this.path = path;
  }

  /**
   * The weight of the texture.
   *
   * @return Weight
   */
  public int getWeight() {
    return this.weight;
  }

  /**
   * The weight of the texture.
   *
   * @param weight Weight
   */
  public void setWeight(int weight) {
    this.weight = weight;
  }
}